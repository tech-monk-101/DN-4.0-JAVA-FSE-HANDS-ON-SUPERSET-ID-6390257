import './App.css';

const books = [
  { id: 101, bname: 'Master React', price: 670 },
  { id: 102, bname: 'Deep Dive into Angular 11', price: 800 },
  { id: 103, bname: 'Mongo Essentials', price: 450 },
];

const blogs = [
  { id: 1, title: 'React Learning', author: 'Stephen Biz', content: 'Welcome to learning React!' },
  { id: 2, title: 'Installation', author: 'Schwezdenier', content: 'You can install React from npm.' },
];

const courses = [
  { id: 1, name: 'Angular', date: '4/5/2021' },
  { id: 2, name: 'React', date: '6/3/2021' },
];

function App() {
  const bookdet = (
    <ul>
      {books.map((book) => (
        <div key={book.id}>
          <h3>{book.bname}</h3>
          <h4>{book.price}</h4>
        </div>
      ))}
    </ul>
  );

  const blogdet = (
    <ul>
      {blogs.map((blog) => (
        <div key={blog.id}>
          <h3>{blog.title}</h3>
          <h4>{blog.author}</h4>
          <p>{blog.content}</p>
        </div>
      ))}
    </ul>
  );

  const coursedet = (
    <ul>
      {courses.map((course) => (
        <div key={course.id}>
          <h3>{course.name}</h3>
          <h4>{course.date}</h4>
        </div>
      ))}
    </ul>
  );

  return (
    <div className="container">
      <div className="mystyle1">
        <h2>Course Details</h2>
        {coursedet}
      </div>
      <div className="st2">
        <h2>Book Details</h2>
        {bookdet}
      </div>
      <div className="v1">
        <h2>Blog Details</h2>
        {blogdet}
      </div>
      
    </div>
  );
}

export default App;