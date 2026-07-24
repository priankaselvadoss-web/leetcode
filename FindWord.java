class FindWord {
    public String[] findWords(String[] words) {
        String[] rows = {"qwertyuiop","asdfghjkl","zxcvbnm"};
        List<String> ans = new ArrayList<>();

        for (String word : words){
            String w = word.toLowerCase();
            for(String row : rows){
                if (w.chars().allMatch(c -> row.indexOf(c) >= 0)) {
                    ans.add(word);
                    break;
                }

            }

        }
        return ans.toArray(new String[0]);
    }
}
