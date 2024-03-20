package com.example.demo.sevice;

import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ProductRelevanceDTO;
import com.example.demo.dto.ShopperProductListDTO;
import com.example.demo.entity.Product;
import com.example.demo.entity.Shopper;
import com.example.demo.entity.ShopperProductRelevance;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ShopperRepository;
import com.example.demo.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ProductServiceTests {
	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private ProductService productService;

	private ProductDTO productDto;
	@Mock
	private ShopperRepository shopperRepository;



	private ShopperProductListDTO shopperProductListDTO;
	@BeforeEach
	void setUp() {
		// Initialize your ProductDTO with sample data
		productDto = new ProductDTO("123", "Electronics", "XYZ Brand");
		ProductRelevanceDTO productRelevanceDTO1 = new ProductRelevanceDTO("Product1", 0.9);
		ProductRelevanceDTO productRelevanceDTO2 = new ProductRelevanceDTO("Product2", 0.8);
		List<ProductRelevanceDTO> shelf = Arrays.asList(productRelevanceDTO1, productRelevanceDTO2);

		shopperProductListDTO = new ShopperProductListDTO("Shopper1", shelf);
	}

	@Test
	public void saveProductMetadata_ThrowsException_IfProductExists() {
		// Arrange
		when(productRepository.existsById(productDto.getProductId())).thenReturn(true);

		// Act & Assert
		assertThrows(IllegalStateException.class, () -> {
			productService.saveProductMetadata(productDto);
		});

		// Verify that the repository's save method was never called
		verify(productRepository, never()).save(any(Product.class));
	}

	@Test
	public void saveProductMetadata_SavesProduct_IfNew() {
		// Arrange
		when(productRepository.existsById(productDto.getProductId())).thenReturn(false);

		// Act
		productService.saveProductMetadata(productDto);

		// Assert & Verify
		verify(productRepository, times(1)).save(any(Product.class));
	}

	@Test
	public void saveShopperProductRelevance_SavesRelevantData() {
		// Act
		productService.saveShopperProductRelevance(shopperProductListDTO);

		// Assert & Verify
		ArgumentCaptor<Shopper> argumentCaptor = ArgumentCaptor.forClass(Shopper.class);
		verify(shopperRepository, times(1)).save(argumentCaptor.capture());

		Shopper savedShopper = argumentCaptor.getValue();
		assertEquals(shopperProductListDTO.getShopperId(), savedShopper.getShopperId());
		List<ShopperProductRelevance> savedShelf = savedShopper.getShelf();

		// Ensure the saved shelf contains the right number of products with correct mappings
		assertEquals(2, savedShelf.size());
		assertTrue(savedShelf.stream().anyMatch(spr -> spr.getProduct().getProductId().equals("Product1") && spr.getRelevancyScore() == 0.9));
		assertTrue(savedShelf.stream().anyMatch(spr -> spr.getProduct().getProductId().equals("Product2") && spr.getRelevancyScore() == 0.8));
	}

}
