package leetcode;

import java.util.*;

/*
实现RandomizedSet 类：

RandomizedSet() 初始化 RandomizedSet 对象
bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1)

 */
public class leetcode_388 {

}

/*
核心思路是用map记录数组每个值对应的下标，在插入和删除时不需要遍历数组寻找对应的数字下标，从而实现插入O(1)
由于删除数组中的数据不是O(1),这里将数组中待删除的数字用数组最后一个数字代替，然后size - 1,下次insert的时候将size位置的数字覆盖，从而实现O(1)删除

 */
class RandomizedSet {

    Map<Integer, Integer> map ;
    List<Integer> list;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        Integer idx = map.get(val);
        if (idx != null) return false;
        list.add(val);
        map.put(val, list.size()-1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer idx = map.get(val);
        if (idx == null) return false;
        map.put(list.get(list.size()-1), idx);
        Collections.swap(list, idx, list.size()-1);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
