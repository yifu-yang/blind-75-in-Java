class MedianFinder {

    PriorityQueue<Integer> big,small;
    public MedianFinder() {
        big = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer number1, Integer number2) {
                return  number2.compareTo(number1);
            }
        });
        small = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(big.size()==0){
            big.add(num);
        }else{
            if(num>big.peek()){
                small.add(num);
                if(small.size()>big.size()){
                    int head = small.poll();
                    big.add(head);
                }
            }else{
                big.add(num);
                if(big.size()>small.size()){
                    int head = big.poll();
                    small.add(head);
                }
            }
        }
    }
    
    public double findMedian() {
        if(small.size()==0){
            return big.peek();
        }else{
            if(((big.size()+small.size())&1)==1){
                return big.size()>small.size()?big.peek():small.peek();
            }else{
                return (big.peek()+small.peek())*1.0/2;
            }
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */