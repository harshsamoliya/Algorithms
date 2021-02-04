// for construction of Trie
// Time complexity -> O(n^2) -> n is the length of String for which we have to make sufix tree
// space complexity -> O(n^2)

// for searching in Trie
// Time complexity -> O(m) -> m is the length of suffix string that we have to found
// space complexity -> O(1)


import java.util.*;

class Program {
    // Do not edit the class below except for the
    // populateSuffixTrieFrom and contains methods.
    // Feel free to add new properties and methods
    // to the class.
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }
    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            for(int i= 0 ; i < str.length();i++){
                insertSubString(i,str);
            }
        }
        public void insertSubString(int  i  ,String  string){
            TrieNode node = this.root;
            for(int currentidx = i ; currentidx<string.length();currentidx++){
                char c = string.charAt(currentidx);
                if(!node.children.containsKey(c)){
                    TrieNode newnode = new TrieNode();
                    node.children.put(c,newnode);
		}
		node = node.children.get(c);
            }
            node.children.put(endSymbol,null);
        }

        public boolean contains(String str) {
            TrieNode node = this.root;
            for(int i = 0 ; i<str.length();i++){
                char  c  = str.charAt(i);
                if(!node.children.containsKey(c)){
                    return false;
                }
                node = node.children.get(c);
            }
            return node.children.containsKey(endSymbol);
        }
    }
}


