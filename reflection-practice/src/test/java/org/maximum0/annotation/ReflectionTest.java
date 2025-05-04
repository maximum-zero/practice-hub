package org.maximum0.annotation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.maximum0.model.User;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ReflectionTest {
    private static final Logger log = LoggerFactory.getLogger(ReflectionTest.class);

    @DisplayName("@Controller 어노테이션이 설정되어 있는 모든 클래스를 찾아서 출력합니다.")
    @Test
    void controllerScanTest() {
        Set<Class<?>> beans = getTypesAnnotatedWith(List.of(Controller.class));
        log.debug("beans [{}]", beans);
    }


    @DisplayName("@Service 어노테이션이 설정되어 있는 모든 클래스를 찾아서 출력합니다.")
    @Test
    void serviceScanTest() {
        Set<Class<?>> beans = getTypesAnnotatedWith(List.of(Service.class));
        log.debug("beans [{}]", beans);
    }

    @DisplayName("클래스에 대한 모든 정보를 출력합니다.")
    @Test
    void showClass() {
        Class<User> clazz = User.class;
        log.debug(clazz.getName());
        log.debug("User all declared constructors: [{}]", Arrays.stream(clazz.getDeclaredConstructors()).collect(Collectors.toList()));
        log.debug("User all declared fields: [{}]", Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toList()));
        log.debug("User all declared methods: [{}]", Arrays.stream(clazz.getDeclaredMethods()).collect(Collectors.toList()));
    }

    @DisplayName("Heap 영역에 Load 되어 있는 클래스 타입의 객체를 가져옵니다.")
    @Test
    void load() throws ClassNotFoundException {
        Class<User> clazz = User.class;

        User user = new User("hong1", "홍길동");
        Class<? extends User> clazz2 = user.getClass();

        Class<?> clazz3 = Class.forName("org.maximum0.model.User");

        log.debug("clazz: [{}]", clazz);
        log.debug("clazz2: [{}]", clazz2);
        log.debug("clazz3: [{}]", clazz3);

        assertThat(clazz).isEqualTo(clazz2);
        assertThat(clazz).isEqualTo(clazz3);
        assertThat(clazz2).isEqualTo(clazz3);
    }

    private Set<Class<?>> getTypesAnnotatedWith(List<Class<? extends Annotation>> annotations) {
        Reflections reflections = new Reflections("org.maximum0");

        Set<Class<?>> beans = new HashSet<>();
        annotations.forEach(annotation -> beans.addAll(reflections.getTypesAnnotatedWith(annotation)));
        return beans;
    }
}
