function getBorrowingHistory(memberId) {
  fetch(`/api/borrow/history/${memberId}`)
    .then(response => response.json())
    .then(data =>   {
    })
    .catch(error => console.error(error));
}
function getBooksBorrowed(bookId) {
  fetch(`/api/borrow/books/${bookId}`)
    .then(response => response.json())
    .then(data =>  {
    })
    .catch(error => console.error(error));
}
function getOverdueBorrows(date) {
  fetch(`/api/borrow/overdue/${date}`)
    .then(response => response.json())
    .then(data => {
    })
    .catch(error => console.error(error));
}
function borrowBook(memberId, bookId, date) {
  fetch(`/api/borrow/${memberId}/${bookId}/${date}`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    }
  })
  .then(response => {
    if (response.ok) {
      console.log('Book borrowed successfully'); 
    } else {
      throw new Error('Error borrowing book');
    }
  })
  .catch(error => {
    console.error(error);
  });
}
function returnBook(memberId, bookId) {
  fetch(`/api/borrow/${memberId}/${bookId}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    }
  })
  .then(response => {
    if (response.ok) {
      console.log('Book returned successfully'); 
    } else {
      throw new Error('Error returning book');
    }
  })
  .catch(error => {
    console.error(error);
  });
}
function deleteBorrow(id) {
  fetch(`/api/borrow/${id}`, {
    method: 'DELETE',
    headers: {
      'Content-Type': 'application/json'
    }
  })
  .then(response => {
    if (response.ok) {
      console.log('Borrow record deleted successfully');
    } else {
      throw new Error('Error deleting borrow record');
    }
  })
  .catch(error => {
    console.error(error);
  });
}
function borrowBook(memberId,bookId,date){
	fetch(`/borrow/${memberId}/${bookId}/${date}`, {
  method: 'POST'
})
.then(response => {
  if (response.ok) {
    console.log('Book borrowed successfully.');
  } else {
    console.error('Failed to borrow book:', response.statusText);
  }
})
.catch(error => {
  console.error('Failed to borrow book:', error);
});
}