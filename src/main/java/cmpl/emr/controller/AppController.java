package cmpl.emr.controller;

import cmpl.emr.model.DepartmentType;
import cmpl.emr.model.Tag;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import cmpl.emr.model.User;
import cmpl.emr.model.UserProfile;
import cmpl.emr.model.UserType;
import cmpl.emr.model.Drug;
import cmpl.emr.model.DrugComposition;
import cmpl.emr.model.patient.Patient;
import cmpl.emr.service.DepartmentTypeService;
import cmpl.emr.service.DrugCompositionService;
import cmpl.emr.service.DrugService;
import cmpl.emr.service.TagService;
import cmpl.emr.service.UserProfileService;
import cmpl.emr.service.UserService;
import cmpl.emr.service.UserTypeService;
import cmpl.emr.service.patient.PatientService;
import cmpl.emr.validator.PasswordValidator;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {
    
    @Autowired
    UserService userService;
    
    @Autowired
    TagService tagService;
    
    @Autowired
    PatientService patientService;

    @Autowired
    UserProfileService userProfileService;
    
    @Autowired
    UserTypeService userTypeService;
    
     @Autowired
    DepartmentTypeService departmentTypeService;

     @Autowired
    DrugService drugService;
     
     @Autowired
    DrugCompositionService drugCompositionService;
     
    @Autowired
    MessageSource messageSource;

    @Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;


    /**
     * This method will list all existing users.
     */
    @RequestMapping(value = {"/", "/entry"}, method = RequestMethod.GET)
    public String entry(ModelMap model) {

        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        model.addAttribute("success", "Hello " + getPrincipal()+ ",Choose your destination");
        return "entry";
    }

      @RequestMapping(value = {"/master"}, method = RequestMethod.GET)
    public String master(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "master";
    }
    
    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("loggedinuser", getPrincipal());
        return "userslist";
    }
    
    @RequestMapping(value = {"/druglist"}, method = RequestMethod.GET)
    public String listDrugs(ModelMap model) {
        Drug drug = new Drug();
        List<Drug> drugs = drugService.findAllDrugs();
        model.addAttribute("druglist", drugs);
        model.addAttribute("drug", drug);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "druglist";
    }
    
    
    @RequestMapping(value = {"/drug"}, method = RequestMethod.GET)
    public String drug(ModelMap model) {

            Drug drugs = new Drug();
            List<Drug> druglist = drugService.findAllDrugs();
            model.addAttribute("drugList", druglist);
            model.addAttribute("drug", drugs);
            model.addAttribute("edit", false);
            model.addAttribute("loggedinuser", getPrincipal());
            return "drug";
    }
    
    @RequestMapping(value = {"/drug"}, method = RequestMethod.POST)
    public String saveDrug(@Valid @ModelAttribute("drug") Drug drug, BindingResult result,
        ModelMap model) {
        if (result.hasErrors()) {
            Drug drugs = new Drug();
            List<Drug> druglist = drugService.findAllDrugs();
            model.addAttribute("drugList", druglist);
            model.addAttribute("drug", drugs);
            model.addAttribute("edit", false);
            model.addAttribute("loggedinuser", getPrincipal());
            return "drug";
        }
            drugService.saveUser(drug);
            Drug drugs = new Drug();
            List<Drug> list = drugService.findAllDrugs();        
            model.addAttribute("drugList", list);
            model.addAttribute("drug", drugs);
            model.addAttribute("edit", false);
            model.addAttribute("success", "Drug for " + drugs.getDiagnosisName() + " registered successfully");
            model.addAttribute("loggedinuser", getPrincipal());
            return "drug";  
    }     

    @RequestMapping(value = {"/edit-drug-{ssoId}"}, method = RequestMethod.GET)
    public String updateDrug( @PathVariable String ssoId, ModelMap model) {
            Drug drugs = new Drug();
            List<Drug> druglist = drugService.findAllDrugs();
            model.addAttribute("drugList", druglist);
            model.addAttribute("drug", drugs);
            model.addAttribute("edit", true);
            model.addAttribute("loggedinuser", getPrincipal());
            return "drug";
    }
    
    /**
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     */
    @RequestMapping(value = {"/edit-drug-{ssoId}"}, method = RequestMethod.POST)
   public String updateDruglist(@Valid Drug drug, BindingResult result, ModelMap model, @PathVariable String ssoId) {
        if (result.hasErrors()) {
            Drug drugs = new Drug();
            List<Drug> druglist = drugService.findAllDrugs();
            model.addAttribute("drugList", druglist);
            model.addAttribute("drug", drugs);
            model.addAttribute("edit", true);
            model.addAttribute("loggedinuser", getPrincipal());
            return "druglist";
        }
            drugService.saveUser(drug);
            Drug drugs = new Drug();
            List<Drug> list = drugService.findAllDrugs();        
            model.addAttribute("drugList", list);
            model.addAttribute("drug", drugs);
            model.addAttribute("edit", false);
            model.addAttribute("success", "Drug for " + drugs.getDiagnosisName() + " updated successfully");
            model.addAttribute("loggedinuser", getPrincipal());
            return "druglist";  
    }     
    
     @RequestMapping(value = {"/delete-drug-{ssoId}"}, method = RequestMethod.GET)
    public String deleteDrug(@PathVariable String ssoId) {
        drugService.deleteUserBySSO(ssoId);
        return "redirect:/druglist";
    }
   
     /**
     * This method will provide drug list to views
     */
    @ModelAttribute("drug")
    public List<DrugComposition> initializeDrugs() {
        return drugCompositionService.findAll();
    }

     @RequestMapping(value = {"/tag"}, method = RequestMethod.GET)
    public String tag(ModelMap model) {

            Tag tags = new Tag();
            List<Tag> taglist = tagService.findAllUsers();        
            model.addAttribute("tagList", taglist);
            model.addAttribute("tag", tags);
            model.addAttribute("edit", false);
            model.addAttribute("loggedinuser", getPrincipal());
            return "tag";
    }
    
      @RequestMapping(value = {"/tag"}, method = RequestMethod.POST)
    public String saveTag(@Valid @ModelAttribute("tag") Tag tag, BindingResult result,ModelMap model) {

        if (result.hasErrors()) {
            Tag tags = new Tag();
            List<Tag> taglist = tagService.findAllUsers();        
            model.addAttribute("TagList", taglist);
            model.addAttribute("tag", tags);
            model.addAttribute("edit", false);
            model.addAttribute("loggedinuser", getPrincipal());
            return "tag";
        }
        tagService.saveUser(tag);
        Tag user = new Tag();
        List<Tag> uType = tagService.findAllUsers();
        model.addAttribute("tagList", uType);
        model.addAttribute("tag", user);
        model.addAttribute("success", "Tag with name " + tag.getType() + "  and asigned Tag " + tag.getAssignTag() + " registered successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        return "tag";
    }     
    
    @RequestMapping(value = {"/edit-tag-{ssoId}"}, method = RequestMethod.GET)
    public String editTag(@PathVariable int ssoId, ModelMap model) {
         Tag tags = tagService.findById(ssoId);
            List<Tag> taglist = tagService.findAllUsers();        
            model.addAttribute("tagList", taglist);
            model.addAttribute("tag", tags);
            model.addAttribute("edit", true);
            model.addAttribute("loggedinuser", getPrincipal());
            return "tag";
    }
    
    /**
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     */
    @RequestMapping(value = {"/edit-tag-{ssoId}"}, method = RequestMethod.POST)
    public String updateTag(@Valid Tag tag, BindingResult result, ModelMap model, @PathVariable int ssoId) {
        if (result.hasErrors()) {
            Tag tags = tagService.findById(ssoId);
            List<Tag> taglist = tagService.findAllUsers();        
            model.addAttribute("tagList", taglist);
            model.addAttribute("tag", tags);
            model.addAttribute("edit", true);
            model.addAttribute("loggedinuser", getPrincipal());
            return "tag";
        }
        tagService.saveUser(tag);
        Tag user = tagService.findById(ssoId);
        List<Tag> uType = tagService.findAllUsers();
        model.addAttribute("tagList", uType);
        model.addAttribute("tag", user);
        model.addAttribute("success", "Tag with name " + tag.getType() + "  and asigned Tag " + tag.getAssignTag() + " updated successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        return "tag";
    }
    
     @RequestMapping(value = {"/delete-tag-{ssoId}"}, method = RequestMethod.GET)
    public String deleteDepartment(@PathVariable String ssoId) {
        tagService.deleteUserBySSO(ssoId);
        return "redirect:/tag";
    }
    
    @RequestMapping(value = {"/departmentType"}, method = RequestMethod.GET)
    public String departmentType(ModelMap model) {
            DepartmentType department = new DepartmentType();
            List<DepartmentType> list = departmentTypeService.findAll();        
            model.addAttribute("departmentTypeList", list);
            model.addAttribute("departmentType", department);
            model.addAttribute("edit", false);
            model.addAttribute("loggedinuser", getPrincipal());
            return "departmentType";  
    }
    
    @RequestMapping(value = {"/departmentType"}, method = RequestMethod.POST)
    public String saveDepartmentType(@Valid @ModelAttribute("departmentType") DepartmentType departmentType, BindingResult result,
        ModelMap model) {
        if (result.hasErrors()) {
            DepartmentType department = new DepartmentType();
            List<DepartmentType> list = departmentTypeService.findAll();        
            model.addAttribute("departmentTypeList", list);
            model.addAttribute("departmentType", department);
            model.addAttribute("edit", false);
            model.addAttribute("loggedinuser", getPrincipal());
            return "departmentType";  
        }
        departmentTypeService.saveDepartmentType(departmentType);
            DepartmentType department = new DepartmentType();
            List<DepartmentType> list = departmentTypeService.findAll();        
            model.addAttribute("departmentTypeList", list);
            model.addAttribute("departmentType", department);
            model.addAttribute("edit", false);
            model.addAttribute("success", "DepartmentType " + departmentType.getType() + " registered successfully");
            model.addAttribute("loggedinuser", getPrincipal());
            return "departmentType";  
    }     
    
      @RequestMapping(value = {"/edit-department-{ssoId}"}, method = RequestMethod.GET)
    public String editDepartment(@PathVariable int ssoId, ModelMap model) {
            DepartmentType department = departmentTypeService.findById(ssoId);
            List<DepartmentType> list = departmentTypeService.findAll();        
            model.addAttribute("departmentTypeList", list);
            model.addAttribute("departmentType", department);
            model.addAttribute("edit", true);
            model.addAttribute("loggedinuser", getPrincipal());
            return "departmentType";  

    }
    
    /**
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     */
    @RequestMapping(value = {"/edit-department-{ssoId}"}, method = RequestMethod.POST)
    public String updateDepartment(@Valid DepartmentType departmentType, BindingResult result, ModelMap model, @PathVariable int ssoId) {
         if (result.hasErrors()) {
            DepartmentType department = departmentTypeService.findById(ssoId);
            List<DepartmentType> list = departmentTypeService.findAll();        
            model.addAttribute("departmentTypeList", list);
            model.addAttribute("departmentType", department);
            model.addAttribute("edit", true);
            model.addAttribute("loggedinuser", getPrincipal());
            return "departmentType";  
        }
        departmentTypeService.saveDepartmentType(departmentType);
            DepartmentType department = departmentTypeService.findById(ssoId);
            List<DepartmentType> list = departmentTypeService.findAll();        
            model.addAttribute("departmentTypeList", list);
            model.addAttribute("departmentType", department);
            model.addAttribute("edit", true);
            model.addAttribute("success", "DepartmentType " + departmentType.getType() + " registered successfully");
            model.addAttribute("loggedinuser", getPrincipal());
            return "departmentType";  
    }
    
     @RequestMapping(value = {"/delete-department-{ssoId}"}, method = RequestMethod.GET)
    public String deleteDepartment(@PathVariable int ssoId) {
        departmentTypeService.deleteBySSO(ssoId);
        return "redirect:/departmentType";
    }
    
    @RequestMapping(value = {"/userTypeMaster"}, method = RequestMethod.GET)
    public String userTypeMaster(ModelMap model) {
        UserType user = new UserType();
        List<UserType> userType = userTypeService.findAll();
        model.addAttribute("userType", userType);
        model.addAttribute("usertype", user);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "userTypeMaster";
    }
   
     @RequestMapping(value = {"/userTypeMaster"}, method = RequestMethod.POST)
    public String saveUserType(@Valid @ModelAttribute("usertype") UserType userType, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
        UserType user = new UserType();
        List<UserType> uType = userTypeService.findAll();
        model.addAttribute("userType", uType);
        model.addAttribute("usertype", user);
        model.addAttribute("loggedinuser", getPrincipal());
            return "userTypeMaster";
        }
        userTypeService.saveUserType(userType);
        UserType user = new UserType();
        List<UserType> uType = userTypeService.findAll();
        model.addAttribute("userType", uType);
        model.addAttribute("usertype", user);
        model.addAttribute("success", "UserType " + userType.getType() + " " + userType.getSub_type() + " registered successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        //return "success";
        return "userTypeMaster";
    }     
    
    @RequestMapping(value = {"/edit-user_profile-{ssoId}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable int ssoId, ModelMap model) {
        UserType user = userTypeService.findById(ssoId);
        List<UserType> userType = userTypeService.findAll();
        model.addAttribute("userType", userType);
        model.addAttribute("usertype", user);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "userTypeMaster";

    }
    
    @RequestMapping(value = {"/delete-user_profile-{ssoId}"}, method = RequestMethod.GET)
    public String deleteUserType(@PathVariable int ssoId) {
        userTypeService.deleteBySSO(ssoId);
        return "redirect:/userTypeMaster";
    }
    /**
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     */
    @RequestMapping(value = {"/edit-user_profile-{ssoId}"}, method = RequestMethod.POST)
    public String updateUserType(@Valid UserType userType, BindingResult result, ModelMap model, @PathVariable int ssoId) {

        if (result.hasErrors()) {
            return "userTypeMaster";
        }
        userTypeService.updateUser(userType);
        UserType user = userTypeService.findById(ssoId);
        List<UserType> uType = userTypeService.findAll();
        model.addAttribute("userType", uType);
        model.addAttribute("usertype", user);
        model.addAttribute("success", "UserType " + userType.getType() + " " + userType.getSub_type() + " registered successfully");
        model.addAttribute("loggedinuser", getPrincipal());
//        userTypeService. updateUser(userType);

        return "userTypeMaster";
    }

    @RequestMapping(value = {"/PatientRegistration"}, method = RequestMethod.GET)
    public String newRegistration(ModelMap model) {
        Patient patient = new Patient();
        model.addAttribute("patient", patient);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "PatientRegistration";
    }
   
    @RequestMapping(value = {"/newpatient"}, method = RequestMethod.POST)
    public String savePatient(@Valid @ModelAttribute("patient") Patient patient, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            return "PatientRegistration";
        }
        patientService.savePatient(patient);
        model.addAttribute("success", "Patient " + patient.getFirst_name() + " " + patient.getLast_name() + " registered successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        //return "success";
        return "entry";
    }
    
    /**
     * This method will provide the medium to add a new user.
     */
    @RequestMapping(value = {"/newuser"}, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "userRegistration";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * saving user in database. It also validates the user input
     */
    @RequestMapping(value = {"/newuser"}, method = RequestMethod.POST)
    public String saveUser(Model model,@Valid User user, BindingResult result) {
        new PasswordValidator().validate(user, result);
        if (result.hasErrors()) {
            return "userRegistration";
        }
        if (!userService.isUserSSOUnique(user.getId(), user.getUsername())) {
            FieldError ssoError = new FieldError("user", "ssoId", messageSource.getMessage("non.unique.ssoId", new String[]{user.getUsername()}, Locale.getDefault()));
            result.addError(ssoError);
            return "userRegistration";
        }

        userService.saveUser(user);

        model.addAttribute("success", "User " + user.getFirst_name()+ " " + user.getLast_name() + " registered successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        //return "success";
        return "registrationsuccess";
    }

    /**
     * This method will provide the medium to update an existing user.
     */
    @RequestMapping(value = {"/edit-user-{ssoId}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable String ssoId, ModelMap model) {
        User user = userService.findBySSO(ssoId);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "userRegistration";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     */
    @RequestMapping(value = {"/edit-user-{ssoId}"}, method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result,
            ModelMap model, @PathVariable String ssoId) {

        if (result.hasErrors()) {
            return "userRegistration";
        }

        /*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/
        userService.updateUser(user);

        model.addAttribute("success", "User " + user.getFirst_name() + " " + user.getLast_name() + " updated successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationsuccess";
    }

    /**
     * This method will delete an user by it's SSOID value.
     */
    @RequestMapping(value = {"/delete-user-{ssoId}"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String ssoId) {
        userService.deleteUserBySSO(ssoId);
        return "redirect:/list";
    }
    
    /**
     * This method will provide UserProfile list to views
     */
    @ModelAttribute("roles")
    public List<UserProfile> initializeProfiles() {
        return userProfileService.findAll();
    }

    /**
     * This method handles Access-Denied redirect.
     */
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("loggedinuser", getPrincipal());
        return "accessDenied";
    }

    /**
     * This method handles login GET requests. If users is already logged-in and
     * tries to goto login page again, will be redirected to list page.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        if (isCurrentAuthenticationAnonymous()) {
            return "login";
        } else {
            return "redirect:/entry";
        }
    }

    /**
     * This method handles logout requests. Toggle the handlers if you are
     * RememberMe functionality is useless in your app.
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            //new SecurityContextLogoutHandler().logout(request, response, auth);
            persistentTokenBasedRememberMeServices.logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/login?logout";
    }

    /**
     * This method returns the principal[user-name] of logged-in user.
     */
    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    /**
     * This method returns true if users is already authenticated [logged-in],
     * else false.
     */
    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }

}
