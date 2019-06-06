package TrieProblems;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TrieContacts {
    static class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord;
        int size;
    }
    private static final String[] input = {"add hacka", "add hackerrank", "add hackathon", "find hack", "find hacka"};
    private static TrieNode root = new TrieNode();
    public static void main(String[] args) {
        for (int i = 0; i < input.length; i++) {
            String[] opContact = input[i].split(" ");

            String op = opContact[0];
            String contact = opContact[1];
            if("add".equalsIgnoreCase(op))
                addContactToTrie(contact);
            else
                System.out.println(findContactInTrie(contact));
        }
    }

    private static void addContactToTrie(String name){
        TrieNode pCrawl = root;
        for(char x : name.toCharArray()){
            pCrawl.children.putIfAbsent(x, new TrieNode());
            pCrawl = pCrawl.children.get(x);
            pCrawl.size++;
        }
        pCrawl.isEndOfWord = true;
    }

    private static int findContactInTrie(String prefix){
        TrieNode pCrawl = root;
        for(char x: prefix.toCharArray()){
            pCrawl = pCrawl.children.get(x);
            if(pCrawl == null)
            	return 0;
        }
        
        return pCrawl.size;
    }
}

