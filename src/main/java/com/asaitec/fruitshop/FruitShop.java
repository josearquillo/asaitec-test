package com.asaitec.fruitshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.asaitec.fruitshop.dto.Purchase;
import com.asaitec.fruitshop.utils.Constants;
import com.asaitec.fruitshop.utils.JSONUtils;

public class FruitShop {

	public static void main(String[] args) {

		
		try {
			// 1 - LOAD STOCK
			JSONArray stockJSON = (JSONArray) JSONUtils.parseJSONFile(Constants.STOCK_FILE).get("items");
			// 2 - LOAD OFFERS
			JSONArray offersJSON = (JSONArray) JSONUtils.parseJSONFile(Constants.OFFERS_FILE).get("offers");
			// 3 - LOAD PURCHASES
			JSONArray purchasesJSON = (JSONArray) JSONUtils.parseJSONFile(Constants.PURCHASES_FILE).get("purchases");
			
			// 4 - CALCULATE SUBTOTALS
			List<Purchase> purchases = new ArrayList<Purchase>();
			
			for (int i=0; i < purchasesJSON.length(); i++) {
				JSONObject purchaseJSON = purchasesJSON.getJSONObject(i);
				Purchase purchase = new Purchase();
				purchase.setItemID(purchaseJSON.getLong("itemID"));
				purchase.setQuantity(purchaseJSON.getLong("quantity"));
				
				Double subtotal = calculateSubtotal(stockJSON,purchaseJSON);
				purchase.setSubtotal(subtotal);
				purchases.add(purchase);
			}
			
			// TODO : 4 - FOR EVERY PURCHASE: APPLY OFFERS
			for (Purchase purchase : purchases) {
				// FIND OFFER
				
				// APPLY OFFER
			}
			
			
			// TODO : 5 - GENERATE RECEIPT
			
			
			// TODO : 6 - WRITE RECEIPT TO JSON FILE
			
		
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Double calculateSubtotal(JSONArray stock, JSONObject purchase) {
		long purchaseItemID = purchase.getLong("itemID");
		long purchaseQuantity = purchase.getLong("quantity");
		Double price = getPrice(stock,purchaseItemID);
		if (price!=null) {
			return price * purchaseQuantity;
		}else {
			return 0d;
		}
	}


	private static Double getPrice(JSONArray stock, long itemID) {
		for (int i=0; i < stock.length(); i++) {
			JSONObject item = stock.getJSONObject(i);
			long currentItemID = item.getLong("itemID");
			if (itemID == currentItemID) {
				return item.getDouble("price");
			}
		}
		return null;
	}
	
}
