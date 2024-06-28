package ra.model;

import ra.utility.InputMethod;

import java.util.List;

//➢ Các thuộc tính:
//        ● productId - String (bắt đầu bằng chữ P và thêm 4 ký tự số , không được trùng lặp );
//● productName - String (Không được để trống )
//● productPrice - double (phải lớn hơn 0)
//● description - String
//● stock - int (ít nhất là 10)
//● catalog - Catalog (không được để null)
//● status - boolean (mặc định là true )
//➢ Các constructor
//➢ Các phương thức:
//        ▪ Các phương thức getter/setter
//▪ Phương thức toString cho phép hiển thị tất cả thông tin sản phẩm (trạng thái
//chuyển thành bán hoặc không bán ) .
public class Product {
    private String productId;
    private String productName;
    private double productPrice;
    private String description;
    private int stock;
    private Catalog catalog;
    private boolean status;

    public Product() {
    }

    public Product(String productId, String productName, double productPrice, String description, int stock, Catalog catalog, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.description = description;
        this.stock = stock;
        this.catalog = catalog;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void displayData() {
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("-");
    }

    ;

    public void inputData(boolean isAdd, List<Product> list) {
        if (isAdd) {
            productId=validateProductId(list);
        }
        System.out.println("Enter the name of the product: ");
        productName=InputMethod.getString();
        System.out.println("Enter the price of the product: ");
        productPrice=InputMethod.getDouble();
        System.out.println("Enter the description of the product: ");
        description=InputMethod.getString();
        System.out.println("Enter the stock of the product: ");
        stock=InputMethod.getInteger();
//        ===================
        System.out.println("Enter the catalog of the product: ");
        catalog=new Catalog();
//=========================
        System.out.println("Enter the status of the product: ");
        status=true;

    }
//    VALIDATE

    public String validateProductId(List<Product> list){
        String regexId= "^P.{3}$";
        while (true){
            System.out.println("Enter the product ID: ");
            String productIdInput= InputMethod.getString();
            if (regexId.matches(productIdInput)){
                boolean checkExist= list.stream().anyMatch(p -> p.getProductId().equals(productIdInput));
                if(checkExist){
                    System.err.println("The product ID already exists!");
                }else {
                    return productIdInput;
                }
            }
        }
    }


}


