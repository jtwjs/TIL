# firstNotRepeatingCharacter [Easy]

>Given a string s consisting of small English letters, find and return the first instance of a non-repeating character in it. If there is no such character, return '_'.

## 1차
```java
char firstNotRepeatingCharacter(String s) {
  ArrayList<Character> list = new ArrayList<>();
    Set<Character> list2 = new HashSet<>();
    for(int i=0;i<s.length();i++){
        list.add(s.charAt(i));
    }
    for(int i=0;i<list.size();i++){
        for(int j=i+1;j<list.size();j++){
            if(list.get(i)==list.get(j))
            list2.add(list.get(i));
        }
    }
    list.removeAll(list2);

return (list.size()==0)?'_':list.get(0);*/
}
```
## 2차
```java
char firstNotRepeatingCharacter(String s) {
 
for(int i=0;i<s.length();i++){
    boolean ox= true;
    for(int j=0;j<s.length();j++){
        if(i!=j&&s.charAt(i)==s.charAt(j)){
        ox=false;
        break;
        }
    }
       if(ox==true)
        return s.charAt(i);
}
 return '_';
}
```