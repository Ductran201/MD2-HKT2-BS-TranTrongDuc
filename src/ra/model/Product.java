package ra.model;

import ra.service.CatalogService;
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
        System.out.println("-----------------------------------------------------------------------" +
                "------------------------");
        System.out.printf("%-5s |%-15s |%-10s |%-15s |%-5s |%-20s |%-6s |\n"
                ,productId,productName,productPrice,description,stock,catalog.getCatalogName(),status);
    }

    ;

    public void inputData(boolean isAdd, List<Product> list) {
        if (isAdd) {
            productId = validateProductId(list);
            status = true;

        }
        System.out.println("Enter the name of the product: ");
        productName = InputMethod.getString();
        productPrice = validateProductPrice();
        System.out.println("Enter the description of the product: ");
        description = InputMethod.getString();
        stock = validateProductStock();
        catalog = validateProductCatalog();

    }
//    VALIDATE

    public String validateProductId(List<Product> list) {
        String regexId = "^P.{3}$";
        while (true) {
            System.out.println("Enter the product ID: ");
            String productIdInput = InputMethod.getString();

            if (productIdInput.matches(regexId)) {
                boolean checkExist = list.stream().anyMatch(p -> p.getProductId().equals(productIdInput));
                if (checkExist) {
                    System.err.println("The product ID already exists!");
                } else {
                    return productIdInput;
                }
            }else {
                System.err.println("The product ID must has total 4 char and begin with 'P' ");
            }
        }
    }

    public double validateProductPrice() {
        while (true) {
            System.out.println("Enter the price of product: ");
            double productPriceInput = InputMethod.getDouble();
            if (productPriceInput <= 0) {
                System.err.println("The price of product must > 0 !");
            } else {
                return productPriceInput;
            }
        }
    }

    public int validateProductStock() {
        while (true) {
            System.out.println("Enter the stock of product: ");
            int productStockInput = InputMethod.getInteger();
            if (productStockInput < 10) {
                System.err.println("The price of product must >= 10 !");
            } else {
                return productStockInput;
            }
        }
    }

    public Catalog validateProductCatalog() {
        CatalogService catalogService = new CatalogService();
        while (true) {
            System.out.println("Enter the id of category for this product: ");
            CatalogService.catalogs.forEach(Catalog::displayData);
            System.out.println("Your choice: ");
            int categoryIdChoice = InputMethod.getInteger();
            Catalog category = catalogService.findById(categoryIdChoice);
            if (category != null) {
                return category;
            } else {
                System.err.println("The id of category invalid, please try again!");
            }
        }
    }


}


