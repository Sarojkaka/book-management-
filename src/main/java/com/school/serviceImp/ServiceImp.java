package com.school.serviceImp;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice.This;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.bookDto.BookDto;
import com.school.bookEntity.Book;
import com.school.bookReposeroty.BookRepository;
import com.school.bookService.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private ModelMapper modelMapper;


	@Override
	public List<BookDto> getAllBook(BookDto bookDto) {
		List <Book> books=this.bookRepository.findAll();
		List<BookDto>bookDtos=
				books.stream().map(book -> this.bookToBookDto(book)).collect(Collectors.toList());
		return bookDtos ;
	}

	@Override
	public BookDto getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookDto update(BookDto bookDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookDto delet(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

		
		
	

	
	@Override
	public BookDto createBook(BookDto bookDto) {
		
		Book book = this.modelMapper.map(bookDto, Book.class);
		//Book book = this.dtoToBook(bookDto);
		Book savedBook = this.bookRepository.save(book);
		return this.modelMapper.map(savedBook, BookDto.class);
		//return this.bookToDto(savedBook);
		//Book book = this.dtoToBook(bookDto);
		//Book savedBook = this.bookRepository.save(book);
		//return this.bookToDto(savedBook);
	}

	//public Book dtoToBook(BookDto bookDto) 
	//{
	//	Book book = this.modelMapper.map(bookDto, Book.class);
	//	return book;
		
	//}
	
	//public BookDto  bookToDto(Book book){
	//	BookDto bookDto = this.modelMapper.map(book, BookDto.class);
	//	return bookDto;

	//	}

	@Override
	public BookDto createBook(BookDto bookDto) {
			Book book=this.dtoTOBook(bookDto);
			Book book2=this.bookRepository.save(book);
			return this.bookToBookDto(book2);

		}



}
