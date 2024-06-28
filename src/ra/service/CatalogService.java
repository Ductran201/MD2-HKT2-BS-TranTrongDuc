package ra.service;

import ra.model.Catalog;
import ra.utility.InputMethod;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CatalogService implements IGenericService<Catalog, Integer> {
    private static final List<Catalog> catalogs = new ArrayList<>();

    @Override
    public Catalog findById(Integer id) {
        return catalogs.stream().filter(c -> c.getCatalogId() == id).findFirst().orElse(null);
    }

    @Override
    public void addNew() {
        System.out.println("Enter the number of category you want to add");
        byte number = InputMethod.getByte();

        for (int i = 1; i <= number; i++) {
            System.out.println("Enter the information of category " + i);
            Catalog newCatalog = new Catalog();
            newCatalog.inputData(true);
            catalogs.add(newCatalog);
        }

        System.out.println("Add successful!!");
    }

    @Override
    public void showAll() {
        System.out.printf("%-5s |%-20s |%-20s |\n"
                , "ID", "NAME", "DESCRIPTION");
        catalogs.forEach(Catalog::displayData);
    }

    @Override
    public void edit() {
        System.out.println("Enter the id of the catalog you want to edit");
        int id = InputMethod.getInteger();
        Catalog categoryEdit = findById(id);
        if (categoryEdit != null) {
            System.out.println("The previous information of this category");
            categoryEdit.displayData();
            categoryEdit.inputData(false);
            System.out.println("Edit successful!!");
        }else {
            System.err.println("The catalog you want to edit does not exist");
        }


    }

    @Override
    public void delete() {
        System.out.println("Enter the id of the catalog you want to edit");
        int id = InputMethod.getInteger();
        Catalog categoryDel = findById(id);
        if (categoryDel != null) {
            catalogs.remove(categoryDel);
            System.out.println("Delete successful!!");
        }else {
            System.err.println("The catalog you want to edit does not exist");
        }
    }

    public static int getNewId(){
        int max=catalogs.stream().map(Catalog::getCatalogId).max(Comparator.naturalOrder()).orElse(0);
        return max+1;
    }
}
