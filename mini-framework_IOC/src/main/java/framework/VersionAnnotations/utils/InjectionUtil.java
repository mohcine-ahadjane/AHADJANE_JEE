package framework.VersionAnnotations.utils;

import static org.burningwave.core.assembler.StaticComponentContainer.Fields;

import java.lang.reflect.Field;
import java.util.Collection;

import framework.VersionAnnotations.Injector;
import org.burningwave.core.classes.FieldCriteria;

import framework.VersionAnnotations.annotations.Autowired;
import framework.VersionAnnotations.annotations.Qualifier;

public class InjectionUtil {

	private InjectionUtil() {
		super();
	}

	/**
	 * Effectuer l'injection de manière récursive, pour chaque service à l'intérieur de la classe Client
	 */
	public static void autowire(Injector injector, Class<?> classz, Object classInstance)
			throws InstantiationException, IllegalAccessException {
		Collection<Field> fields = Fields.findAllAndMakeThemAccessible(
			FieldCriteria.forEntireClassHierarchy().allThoseThatMatch(field ->
				field.isAnnotationPresent(Autowired.class)
			), 
			classz
		);
		for (Field field : fields) {
			String qualifier = field.isAnnotationPresent(Qualifier.class)
					? field.getAnnotation(Qualifier.class).value()
					: null;
			Object fieldInstance = injector.getBeanInstance(field.getType(), field.getName(), qualifier);
			Fields.setDirect(classInstance, field, fieldInstance);
			autowire(injector, fieldInstance.getClass(), fieldInstance);
		}
	}

}
