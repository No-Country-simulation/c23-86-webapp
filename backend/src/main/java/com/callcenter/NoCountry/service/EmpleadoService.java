
package com.callcenter.NoCountry.service;
//
//import com.callcenter.NoCountry.entity.Empleados;
//import com.callcenter.NoCountry.repository.EmpleadoRepository;
//import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmpleadoService implements UserDetailsService{
public class EmpleadoService {
//
//    private final EmpleadoRepository empleadoRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public EmpleadoService(EmpleadoRepository empleadoRepository, PasswordEncoder passwordEncoder){
//        this.empleadoRepository = empleadoRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
//        Empleados empleado = empleadoRepository.findByCorreoEmpresarial(mail)
//                .orElseThrow(() -> new UsernameNotFoundException("Correo inexistente"));
//        return User
//                .withUsername(empleado.getCorreoEmpresarial())
//                .password(empleado.getClave())
//                .build();
//    }
//
//    public void createEmpleado(Empleados empleado){
//        empleado.setClave(passwordEncoder.encode(empleado.getClave()));
//        empleadoRepository.save(empleado);
//    }
}
