import org.junit.Rule;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static sun.nio.cs.Surrogate.is;

@RunWith(MockitoJUnitRunner.class)
public class educationServiceTest {

    public class educationServiceTest {

        @Rule
        public MockitoRule mockitoRule = MockitoJUnit.rule();

        @Mock
        private StudentDataObject studentDataObject;

        @Mock
        private InstructorDataObject instructorDataObject;

        @Mock
        private ClassDataObject classDataObject;

        @InjectMocks
        private ClientBusinessObjectImpl clientBusinessObjectImpl;
}
    @Test
    public void testStudentsByClass() {

        Student studentJM = new Student("Joy Ma", "Spanish");
        Student studentJH = new Student("Julio Hernandez", "Algebra");
        Student studentJJ = new Student("Jenny Jones", "Calculus");
        List<Student> allStudents = Arrays.asList(studentJM, studentJH, studentJJ);

        given(studentDataObject.getAllStudents()).willReturn(allStudents);

        // When
        List<String> mathStudents = clientBusinessObjectImpl.getAllStudentsBySubject("math");

        // Then
        assertThat(mathStudents.size(), is(2));
        assertThat(mathStudents, hasItems(studentJJ, studentJH);
    }


    @Test
    public void testMarkInactive() {

        // Given
        Class geometry = new Class(“Geometry”, “Summer 2022);
        Class envSci = new Class(“Environmental Science”, “Fall 2022”);
        Class compLit = new Class(“Comparative Literature”, “Spring 2023”);
        List<Class> allClasses = Arrays.asList(geometry, envSci, compLit);

        given(classDataObject.getAllClasses()).willReturn(allClasses);

        // When
        clientBusinessObjectImpl.markCurrentClassesInactive();

        // Then
        verify(classDataObject).markInactive(geometry);

        verify(classDataObject, Mockito.never()).markInactive(envSci);

        verify(classDataObject, Mockito.never()).markInactive(compLit);

        verify(classDataObject, Mockito.times(1)).markInactive(geometry);
        // atLeastOnce, atLeast

    }


// First: Setup

    @Captor
    ArgumentCaptor<Class> classArgumentCaptor;

// Next:

    @Test
    public void testMarkInactive_argumentCaptor() {
        // Given
        Class geometry = new Class(“Geometry”, “Summer 2022);
        Class envSci = new Class(“Environmental Science”, “Fall 2022”);
        Class compLit = new Class(“Comparative Literature”, “Spring 2023”);
        List<Class> allClasses = Arrays.asList(geometry, envSci, compLit);

        given(classDataObject.getAllClasses()).willReturn(allClasses);

        // When
        clientBusinessObjectImpl.markCurrentClassesInactive();

        // Then
        verify(classDataObject).markInactive(classArgumentCaptor.capture());

        assertEquals(geometry, classArgumentCaptor.getValue());
    }

    @Test
    public void getClassesByInstructor(String String int){
        Instuctor instructorId1 = new Instuctor("Ben", "Geometry", 2);
        Instuctor instructorId2 = new Instuctor("James", "Environmental Science", 3);
        Instuctor instructorId3 = new Instuctor("William", "Comparative Literature", 1);
        List<Instuctor> allInstructors = Arrays.asList(instructor1, instructor2, instructor3);

        List<String> instructorIdWith2 = InstructorDataObject.getClassesByInstructor(2);

        assertThat(instructorIdWith2.size().is(2));
        assertThat(instructorIdWith2, hasItems(instructorId1);
    }

    @Test
    public void getStudentsInClass(){
        Class geoId = new Class(3);
        Class environmentId = new Class(2);
        Class literatureId = new Class(1);
        List<Class> classesById = Arrays.asList(geoId, environmentId, literatureId);

        given(classDataObject.getStudentInClass()).willReturn(classesById);

        List<String> classIdWith3 = classDataObject.getStudentsInClass(3)

        assertThat(classIdWith3.size().is(3));
        assertThat(classIdWith3, hasItems(geoId);

    }

}
