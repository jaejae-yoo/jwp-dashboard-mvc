package reflection;

import annotation.Controller;
import annotation.Repository;
import annotation.Service;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ReflectionsTest {

    private static final Logger LOG = LoggerFactory.getLogger(ReflectionsTest.class);

    @Test
    void showAnnotationClass() throws Exception {
        Reflections reflections = new Reflections("examples");

        // TODO 클래스 레벨에 @Controller, @Service, @Repository 애노테이션이 설정되어 모든 클래스 찾아 로그로 출력한다.
        Set<Class<?>> controllers = reflections.getTypesAnnotatedWith(Controller.class);
        Set<Class<?>> repositories = reflections.getTypesAnnotatedWith(Repository.class);
        Set<Class<?>> services = reflections.getTypesAnnotatedWith(Service.class);

        controllers.forEach(controller -> LOG.debug("controller: {}", controller.getSimpleName()));
        repositories.forEach(repository -> LOG.debug("repository: {}", repository.getSimpleName()));
        services.forEach(service -> LOG.debug("service: {}", service.getSimpleName()));
    }
}
