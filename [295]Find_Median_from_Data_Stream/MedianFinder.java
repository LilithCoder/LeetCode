package LeetCode;

/***
 * 295. Find Median from Data Stream
 * Median is the middle value in an ordered integer list.
 * If the size of the list is even, there is no middle value.
 * So the median is the mean of the two middle value.
 *
 * For example,
 * [2,3,4], the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 *
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 *
 *
 * Example:
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 *
 * Follow up:
 *
 * If all integer numbers from the stream are between 0 and 100, how would you optimize it?
 * If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */

    public MedianFinder() {

        //lower part of data stream, maxheap on the lower half
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer data1, Integer data2) {
                return data2 - data1;
            }
        });

        //higher part of data stream, minheap on the higher half
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        //add the number to different two halves
        if (maxHeap.isEmpty() || maxHeap.peek() > num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        // re-balance these two halves to
        // make sure the difference between the number of two halves is no more then 2

        if (maxHeap.size() - minHeap.size() >= 2) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() - maxHeap.size() >= 2) {
            maxHeap.add(minHeap.poll());
        }

    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
