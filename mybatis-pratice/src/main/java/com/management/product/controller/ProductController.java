package com.management.product.controller;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;
import com.management.product.model.service.ProductService;
import com.management.product.view.ProductPrint;

import java.util.List;
import java.util.Map;

public class ProductController {


    private final ProductPrint productPrint;
    private final ProductService productService;

    public ProductController() {
        productPrint = new ProductPrint();
        productService = new ProductService();
    }

    public void selectAllProductList() {

        List<ProductDTO> allProductList = productService.selectAllProductList();

        if(allProductList != null && !allProductList.isEmpty()) {
            productPrint.printAllProductList(allProductList);
        } else {
            productPrint.printErrorMessage("selectAllProductList");
        }

    }

    public void selectProductByCondition(SearchCondition searchCondition) {

        List<ProductDTO> productList = productService.selectProductByCondition(searchCondition);

        if(productList != null && !productList.isEmpty()) {
            productPrint.printProductList(productList, searchCondition);
        } else {
            productPrint.printErrorMessage("selectProductList");
        }

    }

    public void registNewProduct(ProductDTO product) {

        product.setReleaseDate(product.getReleaseDate().replaceAll("-",""));
        product.setProductionStatus("Y");
        product.setSalesQuantity("0");

        if(productService.registNewProduct(product)) {
            productPrint.printSuccessMessage("registProduct");
        } else {
            productPrint.printErrorMessage("registProduct");
        }

    }

    public void modifyProductInfo(ProductDTO product) {

        product.setReleaseDate(product.getReleaseDate().replaceAll("-",""));

        if(productService.modifyProductInfo(product)) {
            productPrint.printSuccessMessage("modifyProduct");
        } else {
            productPrint.printErrorMessage("modifyProduct");
        }

    }

    public void deleteProduct(Map<String, String> parameter) {

        if(productService.deleteProduct(parameter)) {
            productPrint.printSuccessMessage("deleteProduct");
        } else {
            productPrint.printErrorMessage("deleteProduct");
        }

    }
}
