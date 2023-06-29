package fetchDepthBug.springTests;

import fetchDepthBug.domain.*;
import fetchDepthBug.repository.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
//@TestPropertySource("classpath:META-INF/spring/mysqltest.properties")
@TestPropertySource("classpath:META-INF/spring/hsqldbtest.properties")
@ContextConfiguration(locations = {
        "/META-INF/spring/context.xml"
})
public abstract class AbstractSpringTestCase {
    @Autowired
    private StepRepository stepRepository;

    @Autowired
    private FormVersionRepository formVersionRepository;

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private ProgramRepository programRepository;

    private Program program;
    private Step step;

    @Before
    public void init() {
        program = new Program();
        programRepository.save(program);
        step = persistData();
    }

    @After
    public void after() {
        stepRepository.deleteAll();
        formVersionRepository.deleteAll();
        formRepository.deleteAll();
        programRepository.deleteAll();
    }

    @Test
    public void formVersionLoadTest() {
        Step fetchedStep = stepRepository.findById(step.getId()).get(); // T3

        StepConfiguration configuration = fetchedStep.getConfiguration();
        assertNotNull(configuration.getFormOptions());
        Assert.assertEquals(1, configuration.getFormOptions().size());
        configuration.getFormOptions().forEach(formOption -> {
            FormVersion fv = formOption.getFormVersion();
            assertNotNull(fv);
        });
    }

    @Test
    public void formInputsLoadTest() {
        Step fetchedStep = stepRepository.findById(step.getId()).get(); // T3

        StepConfiguration configuration = fetchedStep.getConfiguration();
        assertNotNull(configuration.getFormOptions());
        Assert.assertEquals(1, configuration.getFormOptions().size());
        configuration.getFormOptions().forEach(formOption -> {
            FormVersion fv = formOption.getFormVersion();
            assertNotNull(fv);
            assertNotNull(fv.getInputs());
        });
    }
//
//    @Test
//    public void fetchingStepById() {
//        Step fetchedStep = stepRepository.findById(step.getId()).get(); // T3
//
//        StepConfiguration configuration = fetchedStep.getConfiguration();
//        assertNotNull(configuration.getFormOptions());
//        Assert.assertEquals(1, configuration.getFormOptions().size());
//        configuration.getFormOptions().forEach(formOption -> {
//            FormVersion fv = formOption.getFormVersion();
//            assertNotNull(fv); // fails at FD 0, FD 2
//            assertNotNull(fv.getInputs()); // <-- fails at FD 3, FD 1
//            // Passes at FD 4+
//        });
//    }
//
//    @Test
//    public void fetchingStepByIdAndProgramId() {
//        Step fetchedStep = stepRepository.findByIdAndProgramId(step.getId(), program.getId()).get(); // T3
//
//        StepConfiguration configuration = fetchedStep.getConfiguration();
//        assertNotNull(configuration.getFormOptions());
//        Assert.assertEquals(1, configuration.getFormOptions().size());
//        configuration.getFormOptions().forEach(formOption -> {
//            FormVersion fv = formOption.getFormVersion();
//            assertNotNull(fv);
//            assertNotNull(fv.getInputs()); // <-- This will fail
//        });
//    }
//
//    @Test
//    public void fetchingFormOptionsByStepAndProgramId() {
//        Set<FormOption> formOptions = formOptionRepository.findByStepIdAndProgramId(step.getId(), program.getId());
//        formOptions.forEach(formOption -> {
//            FormVersion fv = formOption.getFormVersion();
//            assertNotNull(fv); // (fails when fetch depth 1)
//            assertNotNull(fv.getInputs()); // <-- (fails when fetch depth 0)
//        });
//    }

    private Step persistData() {
        Form form = new Form();

        FormVersion formVersion = new FormVersion(form, 1);
        formVersion.getInputs().add(new FormInput(formVersion));

        formRepository.save(form);
        formVersionRepository.save(formVersion);

        Step step = new Step();
        step.setProgram(program);
        StepConfiguration configuration = new StepConfiguration();
        configuration.setStep(step);

        step.setConfiguration(configuration);

        FormOption formOption = new FormOption();
        formOption.setOrder(1);
        formOption.setConfiguration(step.getConfiguration());
        formOption.setFormVersion(formVersion);
        Set<FormOption> formOptions = new HashSet<>();
        formOptions.add(formOption);
        step.getConfiguration().setFormOptions(formOptions);

        return stepRepository.save(step);
    }

}
