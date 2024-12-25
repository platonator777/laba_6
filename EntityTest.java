// Пример тестируемых классов
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@ToString(ToString.Value.NO)
class BaseEntity extends Entity {
    @ToString(ToString.Value.YES)
    private String includedFieldBase = "BaseFieldIncluded";

    @ToString(ToString.Value.NO)
    private String excludedField = "BaseFieldExcluded";

    private String defaultField = "BaseFieldDefault";
}

class DerivedEntity extends BaseEntity {
    @ToString(ToString.Value.NO)
    private String excludedField = "DerivedFieldExcluded";

    private String includedFieldDerived = "DerivedFieldIncluded";

    private String defaultFieldDerived = "DerivedFieldDefault";
}

class DefaultEntity extends Entity {
    private String fieldA = "FieldA";
    private String fieldB = "FieldB";
}

@ToString(ToString.Value.YES)
class AnnotatedEntity extends DefaultEntity {
    @ToString(ToString.Value.NO)
    private String excludedField = "ExcludedField";

    @ToString(ToString.Value.YES)
    private String includedField = "IncludedField";
}

@ToString(ToString.Value.NO)
class ExcludedEntity extends Entity {
    private String hiddenField = "HiddenField";
}

public class EntityTest {
    /**
     * Тестирует класс DefaultEntity без аннотаций @ToString.
     */
    @Test
    void testDefaultToString() {
        Entity entity = new DefaultEntity();
        String result = entity.toString();
        // Ожидается включение всех полей, так как аннотаций нет
        assertEquals("DefaultEntity{fieldA=FieldA, fieldB=FieldB}", result);
    }

    /**
     * Тестирует класс AnnotatedEntity с аннотацией @ToString(YES) и полями с разными аннотациями.
     */
    @Test
    void testAnnotatedToString() {
        Entity entity = new AnnotatedEntity();
        String result = entity.toString();
        // Ожидается исключение поля с @ToString(NO)
        assertEquals("AnnotatedEntity{includedField=IncludedField, fieldA=FieldA, fieldB=FieldB}", result);
    }

    /**
     * Тестирует класс ExcludedEntity с аннотацией @ToString(NO), который исключает весь класс из вывода.
     */
    @Test
    void testExcludedEntityToString() {
        Entity entity = new ExcludedEntity();
        String result = entity.toString();
        // Ожидается пустой вывод, так как класс помечен @ToString(NO)
        assertEquals("ExcludedEntity{}", result);
    }


    /**
     * Тестирует cупер класс BaseEntity с аннотацией @ToString(NO) и одним полем с @ToString(YES).
     */
    @Test
    void testToStringWithToStringNO() {
        Entity entity = new BaseEntity();
        String result = entity.toString();
        // Ожидается включение только полей с @ToString(YES) в классе и суперклассах
        assertEquals("BaseEntity{includedFieldBase=BaseFieldIncluded}", result);
    }

    /**
     * Тестирует наследующий класс DerivedEntity с аннотацией @ToString(YES) с 3 полями и 1 полем @ToString(NO), у супер класса BaseEntity @ToStiring(NO) и одно поле @ToString(YES).
     */
    @Test
    void testToStringWithToStringYES() {
        Entity entity = new DerivedEntity();
        String result = entity.toString();
        // Ожидается включение всех полей, кроме @ToString(NO)
        assertEquals("DerivedEntity{includedFieldDerived=DerivedFieldIncluded, defaultFieldDerived=DerivedFieldDefault, includedFieldBase=BaseFieldIncluded}", result);
    }
}
