package cs271.lab.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPerformance {

  // TODO run test and record running times for SIZE = 10, 100, 1000, 10000, ...
  // (choose in conjunction with REPS below up to an upper limit where the clock
  // running time is in the tens of seconds)
  // which of the two lists performs better as the size increases?
  private final int SIZE = 100000;

  // TODO choose this value in such a way that you can observe an actual effect
  private final int REPS = 1000000000;

  private List<Integer> arrayList;
  private List<Integer> linkedList;

  public void listAddRemove(List<Integer> list){
    for (int r = 0; r < REPS; r++) {
      list.add(0, 77);
      list.remove(0);
    }
  }

  public void listAccess(List<Integer> list){
    long sum = 0;
    for (int r = 0; r < REPS; r++) {
      sum += list.get(r % SIZE);
    }
  }

  @Before
  public void setUp() throws Exception {
    arrayList = new ArrayList<Integer>(SIZE);
    linkedList = new LinkedList<Integer>();
    for (int i = 0; i < SIZE; i++) {
      arrayList.add(i);
      linkedList.add(i);
    }
  }

  @After
  public void tearDown() throws Exception {
    arrayList = null;
    linkedList = null;
  }

  @Test
  public void testLinkedListAddRemove() {
    listAddRemove(linkedList);
  }

  @Test
  public void testArrayListAddRemove() {
    listAddRemove(arrayList);
  }

  @Test
  public void testLinkedListAccess() {
    listAccess(linkedList);
  }

  @Test
  public void testArrayListAccess() {
    listAccess(arrayList);
  }
}