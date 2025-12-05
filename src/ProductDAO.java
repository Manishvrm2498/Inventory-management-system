import java.io.*;
import java.util.ArrayList;

public class ProductDAO {
      private static final String FILE_PATH = "data/product.csv";

      public static void addProduct(Product p) throws Exception {
          BufferedWriter br = new BufferedWriter(new FileWriter(FILE_PATH, true));
          br.write(p.productDetails());
          br.newLine();
          br.close();
      }

      public static ArrayList<Product> getProducts() throws Exception {
          ArrayList<Product> products = new ArrayList<>();
          File file = new File(FILE_PATH);

          if (!file.exists())
              return products;

          BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
          String line ;
          Product p = null;
          while ((line = br.readLine()) != null) {
              String[] fields = line.split(",");
              p = new Product(Integer.parseInt(fields[0]),
                      fields[1],
                      Integer.parseInt(fields[2]),
                      Double.parseDouble(fields[3]),
                      fields[4]);
              products.add(p);
          }
          br.close();
          return products;
      }


      private static void saveProduct(ArrayList<Product> products) throws Exception {
          BufferedWriter br = new BufferedWriter(new FileWriter(FILE_PATH));

          for (Product p : products){
              br.write(p.productDetails());
              br.newLine();
          }
          br.close();
      }


      public static boolean deleteProduct(int id) throws Exception {
          ArrayList<Product> products = getProducts();

          boolean removed = products.removeIf(product -> product.getId() == id);
          saveProduct(products);
          return removed;
      }


      public static boolean updateProduct(Product newProduct) throws Exception {
          ArrayList<Product> products = getProducts();
          boolean update = false;
          for (int i = 0; i < products.size(); i++) {
              if (products.get(i).getId() == newProduct.getId()) {
                  products.set(i, newProduct);
                  update = true;
                  break;
              }
          }
          saveProduct(products);
          return update;
      }


}
