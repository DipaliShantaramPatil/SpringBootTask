package com.task.registrationcrudoperation.controller;

import com.task.registrationcrudoperation.entity.Product;
import com.task.registrationcrudoperation.exception.ErrorResponse;
import com.task.registrationcrudoperation.exception.SuccessResponse;
import com.task.registrationcrudoperation.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

        @Autowired
        private ProductService productService;

        @PostMapping("product")
        public ResponseEntity<?> createOneProduct(@RequestBody Product product) {
                try {
                        Product createdProduct = productService.createProduct(product);
                        SuccessResponse response = new SuccessResponse(LocalDateTime.now(), HttpStatus.CREATED.value(), "Product created successfully");
                        return ResponseEntity.status(HttpStatus.CREATED).body(response);
                } catch (Exception e) {
                        ErrorResponse response = new ErrorResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

                }
        }

//        @PostMapping
//        public ResponseEntity<Product> createProduct(@RequestParam("image") MultipartFile imageFile,
//                                                     @RequestParam("image1") MultipartFile image1File,
//                                                     @RequestParam("image2") MultipartFile image2File,
//                                                     @RequestParam("product") String productJson) {
//                try {
//                        Product product = productService.createProduct(productJson, imageFile, image1File, image2File);
//                        return ResponseEntity.status(HttpStatus.CREATED).body(product);
//                } catch (IOException e) {
//                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//                }
//        }


        @GetMapping("/product")
        public ResponseEntity<?> getAllProducts() {
                try {
                        List<Product> users = productService.getAllProducts();
                        return ResponseEntity.ok(users);
                } catch (Exception e) {
                        ErrorResponse response = new ErrorResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
                }
        }



        @GetMapping("/product/{productId}")
        public ResponseEntity<?> getproductById(@PathVariable int productId) {
                try {
                        Optional<Product> product = Optional.ofNullable(productService.getProductById(productId));
                        if (product.isPresent()) {
                                return ResponseEntity.ok(product.get());
                        } else {
                                ErrorResponse response = new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "Product not found");
                                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
                        }
                } catch (Exception e) {
                        ErrorResponse response = new ErrorResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
                }
        }

        @DeleteMapping("/product/{productId}")
        public ResponseEntity<?> deleteProductById(@PathVariable int productId) {
                try {
                        productService.deleteProductById(productId);
                        SuccessResponse response = new SuccessResponse(LocalDateTime.now(), HttpStatus.OK.value(), "Product deleted successfully");
                        return ResponseEntity.ok(response);
                } catch (Exception e) {
                        ErrorResponse response = new ErrorResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
                }
        }

        @PutMapping("/product/{productId}")
        public ResponseEntity<?> updateUser(@PathVariable int productId, @RequestBody Product product) {
                try {
                        Product updatedUser = productService.updateProduct(productId, product);
                        if (updatedUser != null) {
                                SuccessResponse response = new SuccessResponse(LocalDateTime.now(), HttpStatus.OK.value(), "User updated successfully");
                                return ResponseEntity.ok(response);
                        } else {
                                ErrorResponse response = new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "User not found");
                                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
                        }
                } catch (Exception e) {
                        ErrorResponse response = new ErrorResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
                }
        }

}
