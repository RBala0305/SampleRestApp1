package com.SampleRestApplication.Demo.Scheduler;

import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.Scheduled;

import com.SampleRestApplication.Demo.Entity.ProductEntity;
import com.SampleRestApplication.Demo.Service.ProductService;
import com.SampleRestApplication.Demo.ServiceExternal.ExternalApiService;

public class PriceUpdateService {

	private final ExternalApiService externalApiService;
	private final ProductService productService;
	
	
//  @Autowired
  public PriceUpdateService(ExternalApiService externalApiService, ProductService productService) {
      this.externalApiService = externalApiService;
      this.productService = productService;
  }

  @Scheduled(fixedRate = 86400000) // Runs every 24 hours
  public void updateProductPrices() {
      // Use pagination with default values
      int defaultPage = 0;
      int defaultSize = 100;
      
      Page<ProductEntity> productPage = productService.getAllProducts(defaultPage, defaultSize);
      
      // Process each page
      while (productPage.hasContent()) {
          for (ProductEntity product : productPage.getContent()) {
              // Fetch the latest price and update the product
              Double newPrice = externalApiService.fetchLatestPrice(product.getId().toString());
              product.setPrice(newPrice);
              productService.updateProduct(product.getId(), product);
          }
          
          // Fetch the next page
          defaultPage++;
          productPage = productService.getAllProducts(defaultPage, defaultSize);
      }
  }
}


    