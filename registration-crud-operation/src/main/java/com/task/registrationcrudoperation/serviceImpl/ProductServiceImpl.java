package com.task.registrationcrudoperation.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.registrationcrudoperation.entity.Product;
import com.task.registrationcrudoperation.repository.ProductRepo;
import com.task.registrationcrudoperation.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Configuration
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

//@Override
//public Product createProduct(String productJson, MultipartFile imageFile, MultipartFile image1File, MultipartFile image2File) throws IOException {
//    Product product = new ObjectMapper().readValue(productJson, Product.class);
//    product.setImage(imageFile.getBytes());
//    product.setImage1(image1File.getBytes());
//    product.setImage2(image2File.getBytes());
//    return productRepo.save(product);
//}

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(int productId) {
        Optional<Product> optionalProduct = productRepo.findById(productId);
        return optionalProduct.orElse(null);
    }

    @Override
    public void deleteProductById(int productId) {
        productRepo.deleteById(productId);
    }

    @Override
    public Product updateProduct(int productId, Product product) {
        return productRepo.save(product);
    }
}



