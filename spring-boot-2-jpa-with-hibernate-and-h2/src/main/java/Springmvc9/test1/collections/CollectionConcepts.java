package Springmvc9.test1.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollectionConcepts {
	
	@GetMapping("/collection")
	public void Collections(){
		Item door=new Item("Wooden Door", 35);
		Item floorPanel=new Item("Floor Panel", 15);
		Item window=new Item("Glass Window", 80);
		
		//泛型類型表示集合中的每個元素都是一個Item
		//ArrayList實現了List接口，list接口擴展了collection接口
		//因此我們可以接arraylist分配給集合變量
		Collection<Item> items=new ArrayList<Item>();
		items.add(door);
		items.add(floorPanel);
		items.add(window);
		
		System.out.println("整個印出集合"+items);
		
		//選代器他允許我們一次一個遍歷元素，用於使用任何集合
		Iterator<Item> itemIterator=items.iterator();
		while(itemIterator.hasNext()) {
			Item item=itemIterator.next();
			if(item.getWeight()>20) {
				System.out.println("重量大於20"
						+ "才印出"+item);
			}else {
				itemIterator.remove();
			}
		}
		
		for(Item item:items) {
			System.out.println("刪除過後再印出"+item);
		}
		
		System.out.println("判斷是否為空"+items.isEmpty());
		System.out.println("判斷集合數量"+items.size());
		
		System.out.println("查詢集合中是否有window"+items.contains(window));
		System.out.println("查詢集合中是否有door"+items.contains(door));
		System.out.println("查詢集合中是否有floorPanel"+items.contains(floorPanel));
		
		Collection<Item> otherItems=new ArrayList<>();
		otherItems.add(window);
		otherItems.add(door);
		
		items.removeAll(otherItems);
		System.out.println("使用removeall刪除一個集合"+items);
		//上面2者相比for是比較乾淨但會甚麼需要選代器呢，因為有些東西
		//不能用for做，因為你修改集合時會造成錯誤，如果你要修改請使用選代器
		/*
		for(Item item:items) {
			if(item.getWeight()>20) {
				System.out.println("重量大於20"
						+ "才印出"+item);
			}else {
				items.remove(item);
			}
		}
		*/
		
	}
	
	@GetMapping("/")
	public void LIST(){
		
	}
	
	
}
