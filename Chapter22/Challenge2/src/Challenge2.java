/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   27/02/2017.
 */
public class Challenge2
{
    public static void main(String[] args)
    {
        GenealogyTree gt = new GenealogyTree();
        System.out.println("Add root = " + gt.addRoot("Bossman"));
        System.out.println("Add left Bossman Kiddo = " + gt.addChild(true, "Bossman", "Kiddo"));
        System.out.println("Add left Bossman Frog = " + gt.addChild(true, "Bossman", "Frog"));
        System.out.println("Add right Tessa Daisy = " + gt.addChild(false, "Tessa", "Daisy"));
        System.out.println("Add right Kiddo Daisy = " + gt.addChild(false, "Kiddo", "Daisy"));
        System.out.println("Add left Kiddo Jessie = " + gt.addChild(true, "Kiddo", "Jessie"));

        gt.getPerson("Frog");
        gt.getPerson("Daisy");

        System.out.println("Descendants of Bossman: " + gt.descendants("Bossman"));
        System.out.println("Descendants of Frodo: " + gt.descendants("Frodo"));
        System.out.println("Descendants of Kiddo: " + gt.descendants("Kiddo"));
        System.out.println("Descendants of Daisy: " + gt.descendants("Daisy"));
        System.out.println("Ancestors of Daisy: " + gt.ancestors("Daisy"));
        System.out.println("Ancestors of Frodo: " + gt.ancestors("Frodo"));
        System.out.println("Ancestors of Kiddo: " + gt.ancestors("Kiddo"));
        System.out.println("Ancestors of Bossman: " + gt.ancestors("Bossman"));

        new GTreeGUI();
    }
}
