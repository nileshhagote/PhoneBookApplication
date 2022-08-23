package com.BikkadIT.Repository;

import org.eclipse.jdt.internal.compiler.env.IModule.IPackageExport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BikkadIT.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
