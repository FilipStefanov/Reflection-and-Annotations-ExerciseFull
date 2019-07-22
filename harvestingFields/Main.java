package harvestingFields;

import java.lang.reflect.Field;

import java.lang.reflect.Modifier;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		RichSoilLand richSoilLand = new RichSoilLand();
		Field[] declaredFields = richSoilLand.getClass().getDeclaredFields();
		String input = "";

		while (!"HARVEST".equals( input = scanner.nextLine())) {

			Map<String, List<Field>> listMap = new HashMap<>();



			if (input.equals("all")){
				Arrays.stream(declaredFields)
							.forEach(field -> System.out.printf(
									"%s %s %s%n",
									Modifier.toString(field.getModifiers()),
									field.getType().getSimpleName()
									,field.getName()


							));
			}else{
				String finalInput = input;
				Arrays.stream(declaredFields)
						.filter(field -> Modifier.toString(field.getModifiers()).equals(finalInput))
						.forEach(field -> System.out.printf(
								"%s %s %s%n",
								Modifier.toString(field.getModifiers()),
								field.getType().getSimpleName()
								,field.getName()


						));

			}

//			switch (input){
//				case"private":
//					Arrays.stream(declaredFields)
//							.filter(field -> {
//							return	Modifier.isPrivate(field.getModifiers());
//							})
//							.forEach(field -> System.out.printf(
//									"private %s %s%n",
//									field.getType().getSimpleName()
//									,field.getName()
//
//
//						));
//					break;
//				case"protected":
//					Arrays.stream(declaredFields)
//							.filter(field -> {
//								return	Modifier.isProtected(field.getModifiers());
//							})
//							.forEach(field -> System.out.printf(
//									"protected %s %s%n",
//									field.getType().getSimpleName()
//									,field.getName()
//
//
//							));
//					break;
//				case"public":
//					Arrays.stream(declaredFields)
//							.filter(field -> {
//								return	Modifier.isPublic(field.getModifiers());
//							})
//							.forEach(field -> System.out.printf(
//									"public %s %s%n",
//									field.getType().getSimpleName()
//									,field.getName()
//
//
//							));
//					break;
//				case"all":
//					Arrays.stream(declaredFields)
//							.forEach(field -> System.out.printf(
//									"%s %s %s%n",
//									Modifier.toString(field.getModifiers()),
//									field.getType().getSimpleName()
//									,field.getName()
//
//
//							));
//					break;
//
//			}



		}

	}
}
