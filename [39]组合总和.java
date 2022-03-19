class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Map<Integer,List<List<Integer>>> ans = new ConcurrentHashMap<>();
        for(int num:candidates){
            List<Integer> list = new ArrayList<>();
            list.add(num);
            List<List<Integer>> value = new ArrayList<>();
            value.add(list);
            ans.put(num,value);
        }
        int keyCount = 0;
        while(keyCount!=ans.keySet().size()){
            keyCount = ans.keySet().size();
            for(int key :ans.keySet()){
                for (int candidate : candidates) {
                    if (candidate + key > target) {
                        continue;
                    }
                    if (ans.containsKey(candidate + key)) {
                        List<List<Integer>> value = ans.get(candidate + key);
                        int tmp = candidate;
                        List<List<Integer>> sub = ans.get(key).stream().map(x -> {
                            List<Integer> t = new ArrayList<>(x);
                            t.add(tmp);
                            return t;
                        }).collect(Collectors.toList());
                        value.addAll(sub);
                        ans.put(key + tmp, value);
                    } else {
                        int tmp = candidate;
                        List<List<Integer>> sub = ans.get(key).stream().map(x -> {
                            List<Integer> t = new ArrayList<>(x);
                            t.add(tmp);
                            return t;
                        }).collect(Collectors.toList());
                        ans.put(key + tmp, sub);
                    }
                }
            }
        }
        List<List<Integer>> sorted = ans.getOrDefault(target,new ArrayList<>()).stream().map(x->x.stream().sorted().collect(Collectors.toList())).collect(Collectors.toList());
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> integers : sorted) {
            if (result.size() == 0) {
                result.add(integers);
                continue;
            }
            if (!result.contains(integers)) {
                result.add(integers);
            }
        }
        return result;
    }
}
