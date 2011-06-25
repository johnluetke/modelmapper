package org.modelmapper.internal.converter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.internal.converter.ArrayConverter;
import org.testng.annotations.Test;

/**
 * @author Jonathan Halterman
 */
@Test
public class ArrayConverterTest extends AbstractConverterTest {
  public ArrayConverterTest() {
    super(new ArrayConverter());
  }

  static class S {
    int[] array = new int[] { 4, 5, 6 };
  }

  static class D {
    String[] array;
  }

  static class LongList extends ArrayList<Long> {
  }

  public void shouldConvertNestedElements() {
    Object[] source = new Object[] { Arrays.asList(1, 2, 3), new int[] { 4, 5, 6 } };
    Object[] dest = (Object[]) modelMapper.map(source, Object[].class);
    assertEquals(dest[0], Arrays.asList(1, 2, 3));
    assertEquals(dest[1], new int[] { 4, 5, 6 });
  }

  public void shouldConvertElementsFromArray() {
    int[] source = new int[] { 1, 2, 3 };
    String[] dest = (String[]) modelMapper.map(source, String[].class);
    assertEquals(dest, new String[] { "1", "2", "3" });
  }

  public void shouldConvertElementsFromModel() {
    D d = modelMapper.map(new S(), D.class);
    assertEquals(d.array, new String[] { "4", "5", "6" });
  }

  public void shouldConvertFromSet() {
    Set<Integer> source = new HashSet<Integer>(Arrays.asList(3, 4, 5));
    String[] dest = (String[]) convert(source, String[].class);
    assertEquals(Arrays.<String>asList(dest), Arrays.asList("3", "4", "5"));
  }

  public void shouldConvertFromList() {
    List<String> source = Arrays.asList("a", "b", "c");
    Object[] dest = (Object[]) convert(source, Object[].class);
    assertEquals(Arrays.asList(dest), source);
  }

  public void shouldConvertFromPrimitiveArray() {
    int[] source = new int[] { 1, 2, 3 };
    int[] dest = (int[]) convert(source, int[].class);
    assertEquals(dest, source);
  }

  public void shouldConvertFromArray() {
    String[] source = new String[] { "a", "b", "c" };
    assertEquals((String[]) convert(source, String[].class), source);
  }

  public void testMatches() {
// TODO fix
    //    assertTrue(converter.supports(ArrayList.class, ArrayList.class, Object[].class, Object[].class));
//    assertTrue(converter.supports(Object[].class, Object[].class, String[].class, String[].class));
//    assertTrue(converter.supports(LongList.class, LongList[].class, Long[].class, Long[].class));
//    
//    // Negative
//    assertFalse(converter
//        .supports(Object[].class, Object[].class, ArrayList.class, ArrayList.class));
  }
}
