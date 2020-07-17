package tc.task01.main;

import static tc.task01.entity.criteria.SearchCriteria.*;

import tc.task01.entity.Appliance;
import tc.task01.entity.criteria.Criteria;
import tc.task01.entity.criteria.SearchCriteria;
import tc.task01.service.ApplianceService;
import tc.task01.service.ServiceFactory;

import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {



		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////
//
//		Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());//"Oven"
//		criteriaOven.add(Oven.CAPACITY.toString(), 3);
//
//		Set<Appliance> appliance = service.find(criteriaOven);
//
//		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////

//		criteriaOven = new Criteria(Oven.class.getSimpleName());
//		criteriaOven.add(Oven.HEIGHT.toString(), 200);
//		criteriaOven.add(Oven.DEPTH.toString(), 300);

//		appliance = service.find(criteriaOven);

//		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////
		
//		Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
//		criteriaTabletPC.add(TabletPC.COLOR.toString(), "BLUE");
//		criteriaTabletPC.add(TabletPC.DISPLAY_INCHES.toString(), 14);
//		criteriaTabletPC.add(TabletPC.MEMORY_ROM.toString(), 8000);
//
//		Set<Appliance> appliance = service.find(criteriaTabletPC);// find(Object...obj)
//
//		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////

		Criteria criteriaLaptop = new Criteria(Laptop.class.getSimpleName());
		criteriaLaptop.add(Laptop.OS.toString(), 3);
//		criteriaLaptop.add(Laptop.DISPLAY_INCHES.toString(), 14);
		criteriaLaptop.add(Laptop.BATTERY_CAPACITY.toString(), "d");
		criteriaLaptop.add(Laptop.SYSTEM_MEMORY.toString(), 30004444);

		Set<Appliance> appliance = service.find(criteriaLaptop);// find(Object...obj)

		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////

//		Criteria refrigeratorCriteria = new Criteria(Refrigerator.class.getSimpleName());
//		refrigeratorCriteria.add(Refrigerator.POWER_CONSUMPTION.toString(), 200);
//		refrigeratorCriteria.add(Refrigerator.WEIGHT.toString(), 30);
//
//		Set<Appliance> appliance = service.find(refrigeratorCriteria);// find(Object...obj)
//
//		PrintApplianceInfo.print(appliance);

	}

}
