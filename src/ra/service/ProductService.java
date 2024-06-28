package ra.service;

import ra.model.Product;
import ra.utility.InputMethod;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IGenericService<Product, String>{
    private static final List<Product> products=new ArrayList<>();

    @Override
    public Product findById(String id) {

        return products.stream().filter(p-> p.getProductId().equals(id)).findFirst().orElse(null);

    }

    @Override
    public void addNew() {
        System.out.println("Enter the number of products you want to add");
        byte number = InputMethod.getByte();

        for (int i = 1; i <=number ; i++) {
            System.out.println("Enter the information of product "+ i);
            Product newProduct = new Product();
            newProduct.inputData(true,products);
            products.add(newProduct);
        }

        System.out.println("Add successfully!!");
    }

    @Override
    public void showAll() {
        products.forEach(Product::displayData);
    }

    @Override
    public void edit() {
        System.out.println("Enter id of the product you want to edit");
        String id = InputMethod.getString();
        Product productEdit=findById(id);
        if (productEdit!=null){
            System.out.println("The previous information of this product: ");
            productEdit.displayData();
            productEdit.inputData(false,products);
        }else {
            System.err.println("The product does not exist");
        }
    }

    @Override
    public void delete() {
        System.out.println("Enter id of the product you want to edit");
        String id = InputMethod.getString();
        Product productDel=findById(id);
        if (productDel!=null){
            products.remove(productDel);
        }else {
            System.err.println("The product does not exist");
        }
    }

    public void sortByPrice(){
        products.stream().sorted((o1, o2) -> (int) (o2.getProductPrice()- o1.getProductPrice()));
    }


}
