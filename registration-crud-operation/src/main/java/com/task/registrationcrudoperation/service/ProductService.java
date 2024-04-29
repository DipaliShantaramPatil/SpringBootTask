package com.task.registrationcrudoperation.service;

import com.task.registrationcrudoperation.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface ProductService {

//    Product createProduct(String product, MultipartFile imageFile, MultipartFile image1File, MultipartFile image2File) throws IOException;


    public Product createProduct(Product product);

    public List<Product> getAllProducts();

    Product getProductById(int productId);

    void deleteProductById(int productId);

    Product updateProduct(int productId, Product product);


}
