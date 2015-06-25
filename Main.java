package ir.amfad;

/*Huffman code encoder
*        Copyright (C) 2015  Amir Hosein Fadaei
*
*       This program is free software: you can redistribute it and/or modify
*        it under the terms of the GNU General Public License as published by
*        the Free Software Foundation, either version 3 of the License, or
*        (at your option) any later version.
*
*        This program is distributed in the hope that it will be useful,
*        but WITHOUT ANY WARRANTY; without even the implied warranty of
*        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*        GNU General Public License for more details.
*
*        You should have received a copy of the GNU General Public License
*        along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

import ir.amfad.Tree.Node;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hi! enter \":exit\" to exit!");
        while(true) {
            System.out.println("Notification : Started building tree ...");
            System.out.println("Please enter symbols:affluence like \"a:23\"");
            System.out.println(": symbol is invalid");
            System.out.println("only one character is available before :");
            System.out.println("enter \":end\" to end!");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Map map = new HashMap();
            String in;
            while (true) {
                try {
                    in = br.readLine();
                    if (in.equals(":end"))
                        break;
                    if (in.equals(":exit"))
                        return;
                    String[] parts = in.split(":");
                    map.put(parts[0], parts[1]);
                } catch (Exception e) {
                    System.out.println("Error, Wrong Input... :|");
                    e.printStackTrace();
                }
            }
            Huffman h = new Huffman(map);
            System.out.println("Ready for encoding!please enter sentences like \"Hello!\"");
            System.out.println("Symbols must be defined in lang or they wont get encoded");
            System.out.println("enter \":reset\" to reset the tree!");
            while (true) {
                try {
                    in = br.readLine();
                    if (in.equals(":end"))
                        break;
                    if (in.equals(":exit"))
                        return;
                    System.out.println("encoded sent is : " + h.encode(in));
                } catch (Exception e) {
                    System.out.println("Error, Wrong Input... :|");
                    e.printStackTrace();
                }
            }
        }
    }
}
