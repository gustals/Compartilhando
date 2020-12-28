package com.compartilhando.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.compartilhando.enums.TipoImagem;
import com.fasterxml.jackson.core.JsonProcessingException;


@Service
public class ImagemService {
	@Value("${compartilhando.imagens.raiz}")
	private String raiz;
	
	@Value("${contato.disco.diretorio.fotosUsuario}")
	private String diretorioFotosUsuario;
	
	@Value("${contato.disco.diretorio.fotosPost}")
	private String diretorioFotosPost;
	
	@Value("${compartilhando.imagens.fotos.perfilPadrao}")
	private String fotoPadraoUsuario;
	
	@Value("${compartilhando.imagens.fotos.postPadrao}")
	private String fotoPadraoPost;
	
	public String salvarFoto(TipoImagem tipoImagem, Long id,MultipartFile foto) {
		if(foto==null) {
			if(tipoImagem.equals(tipoImagem.USUARIO))
				return this.fotoPadraoUsuario;
			else
				return this.fotoPadraoPost;
		}
			
		if(tipoImagem.equals(tipoImagem.USUARIO))
			return this.salvar(this.diretorioFotosUsuario, id, foto);
		else
			return this.salvar(this.diretorioFotosPost, id, foto);
	}
	
	public String salvar(String diretorio, Long id, MultipartFile arquivo) {
		String extensao = arquivo.getOriginalFilename().split("\\.")[1];
		String nomeArquivo = id  + "." + extensao;
		
		Path diretorioPath = Paths.get(this.raiz, diretorio);
		Path arquivoPath = diretorioPath.resolve(nomeArquivo);
		
		try {
			Files.createDirectories(diretorioPath);
			arquivo.transferTo(arquivoPath.toFile());	
			return arquivoPath.toString();
		} catch (IOException e) {
			throw new RuntimeException("Problemas na tentativa de salvar arquivo.", e);
		}		
	}
}
