class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for(String email : emails){
            set.add(getEmail(email));
        }
        return set.size();
    }
    public String getEmail(String email){
        String localName = "";
        String domain = "";
        for(int i = 0; i < email.length(); i++){
            if(email.charAt(i) == '@'){
                localName = email.substring(0, i);
                domain = email.substring(i+1, email.length());
                break;
            }
        }
        for(int i = 0; i < localName.length(); i++){
            char ch = localName.charAt(i);
            if(ch == '.'){
                localName = localName.substring(0, i);
            }
            if(ch == '+'){
                localName = localName.substring(0, i);
                break;
            }
        }
        return localName + domain;
    }
}