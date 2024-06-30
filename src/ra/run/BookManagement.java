package ra.run;

import ra.service.CatalogService;
import ra.service.ProductService;
import ra.utility.InputMethod;


public class BookManagement {
    static CatalogService categoryService = new CatalogService();
    static ProductService productService = new ProductService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("**************************BASIC-MENU**************************\n" +
                    "1. Quản lý danh mục [5 điểm]\n" +
                    "2. Quản lý sản phẩm [5 điểm]\n" +
                    "3. Thoát [5 điểm]");
            System.out.println("Your choice: ");
            byte choice = InputMethod.getByte();
            switch (choice) {
                case 1:
                    openCatalogManagement();
                    break;
                case 2:
                    openProductManagement();
                    break;
                case 3:
                    return;
            }
        }
    }

    public static void openCatalogManagement() {
        while (true) {
            System.out.println("********************CATALOG-MANAGEMENT********************\n" +
                    "1. Nhập số danh mục thêm mới và nhập thông tin cho từng danh mục [5 điểm]\n" +
                    "2. Hiển thị thông tin tất cả các danh mục [5 điểm]\n" +
                    "3. Sửa tên danh mục theo mã danh mục [5 điểm]\n" +
                    "4. Xóa danh muc theo mã danh mục (lưu ý ko xóa khi có sản phẩm) [5 điểm]\n" +
                    "5. Quay lại");
            System.out.println("Your choice: ");
            byte choice = InputMethod.getByte();
            switch (choice) {
                case 1:
                    categoryService.addNew();
                    break;
                case 2:
                    categoryService.showAll();
                    break;
                case 3:
                    categoryService.edit();
                    break;
                case 4:
                    categoryService.delete();
                    break;
                case 5:
                    return;

            }

        }
    }

    public static void openProductManagement() {
        while (true) {
            System.out.println("********************PRODUCT-MANAGEMENT********************\n" +
                    "1. Nhập số sản sản phẩm và nhập thông tin sản phẩm [5 điểm]\n" +
                    "2. Hiển thị thông tin các sản phẩm [5 điểm]\n" +
                    "3. Sắp xếp sản phẩm theo giá giảm dần [5 điểm]\n" +
                    "4. Xóa sản phẩm theo mã [5 điểm]\n" +
                    "5. Tìm kiếm sách theo tên sách [10 điểm]\n" +
                    "6. Thay đổi thông tin của sách theo mã sách [10 điểm]\n" +
                    "7. Quay lại\n");

            System.out.println("Your choice: ");

            byte choice = InputMethod.getByte();
            switch (choice) {
                case 1:
                    productService.addNew();
                    break;
                case 2:
                    productService.showAll();
                    break;
                case 3:
                    productService.sortByPrice();
                    break;
                case 4:
                    productService.delete();
                    break;
                case 5:
                    productService.searchByName();
                    break;
                case 6:
                    productService.edit();
                    break;
                case 7:
                    return;
            }

        }
    }
}
