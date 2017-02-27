/**
 * 
 */
package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Mohamed Mohamed
 *
 */
public class CollectionsTest
{
       
    HashSet<Integer> set;
    
    List<Integer> list;
    
    @Before
    public void setUp()
    {
        set = new HashSet<Integer>();
        list = new ArrayList<Integer>();
    }

    @Test (expected = NullPointerException.class)
    public void disjoint_OneNullCollection()
    {
        Collections.disjoint(null, set);
    }
    
    @Test
    public void disjoint_TwoEmptyCollectionsOfSameTypes_ExpectedTrue()
    {
        assertTrue(Collections.disjoint(set, set));
    }
    
    @Test
    public void disjoint_CollectionsOfSameTypeHaveNoCommonElements_ExpectedTrue()
    {
        HashSet<Integer> sameCollectionType = new HashSet<Integer>();
        for (int i = 0; i < 10; i++)
        {
            set.add(i);
            sameCollectionType.add(10 + i);
        }
        assertTrue(Collections.disjoint(set, sameCollectionType));
    }
    
    @Test
    public void disjoint_CollectionsOfSameTypeHaveSomeCommonAndSomeUnCommonElements_ExpectedFalse()
    {
        HashSet<Integer> sameCollectionType = new HashSet<Integer>();
        for (int i = 0; i < 10; i++)
        {
            set.add(i);
        }
        sameCollectionType.add(1);
        sameCollectionType.add(2);
        assertFalse(Collections.disjoint(set, sameCollectionType));
    }
    
    @Test
    public void disjoint_CollectionsOfSameTypeHaveSameElements_ExpectedFalse()
    {
        HashSet<Integer> sameCollectionType = new HashSet<Integer>();
        for (int i = 0; i < 10; i++)
        {
            set.add(i);
            sameCollectionType.add(i);
        }
        assertFalse(Collections.disjoint(set, sameCollectionType));
    }
    
    @Test
    public void disjoint_TwoEmptyCollectionsofDifferemtTypes_ExpectedTrue()
    {
        assertTrue(Collections.disjoint(set, list));
    }
    
    @Test
    public void disjoint_CollectionsOfDifferentTypeHaveNoCommonElements_ExpectedTrue()
    {
        for (int i = 0; i < 10; i++)
        {
            set.add(i);
            list.add(10 + i);
        }
        assertTrue(Collections.disjoint(set, list));
    }
    
    @Test
    public void disjoint_CollectionsOfDifferentTypeHaveSomeCommonAndSomeUnCommonElements_ExpectedFalse()
    {
        
        for (int i = 0; i < 10; i++)
        {
            set.add(i);
        }
        list.add(1);
        list.add(2);
        assertFalse(Collections.disjoint(set, list));
    }
    
    @Test
    public void disjoint_CollectionsOfDifferentTypeHaveSameElements_ExpectedFalse()
    {
        
        for (int i = 0; i < 10; i++)
        {
            set.add(i);
            list.add(i);
        }
        assertFalse(Collections.disjoint(set, list));
    }
    

    

}
