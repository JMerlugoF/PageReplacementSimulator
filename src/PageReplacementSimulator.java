import java.util.Scanner;
import java.util.LinkedList;

public class PageReplacementSimulator {
  static LinkedList<Integer> memory = new LinkedList<Integer>();
  static int pageFaults = 0;
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Insira o n de quadros da memoria: ");
    int frameCount = sc.nextInt();
    System.out.print("\nInsira o n de paginas: ");
    int pageCount = sc.nextInt();
    int[] pages = new int[pageCount];
    System.out.print("\nInsira as paginas de referencia:");
    for (int i = 0; i < pageCount; i++) {
      pages[i] = sc.nextInt();
    }
    sc.close();
    simulate(frameCount, pages);
    System.out.println("\n\nFalhas de página: " + pageFaults);
  }
  
  public static void simulate(int frameCount, int[] pages) {
    System.out.println("\n");
    for (int i = 0; i < pages.length; i++) {
      if (!memory.contains(pages[i])) {
        if (memory.size() == frameCount) {
          memory.removeFirst();
        }
        memory.addLast(pages[i]);
        pageFaults++;
      }
      System.out.println("Estado da memória após acessar a página " + pages[i] + ": " + memory);
    }
  }
}
