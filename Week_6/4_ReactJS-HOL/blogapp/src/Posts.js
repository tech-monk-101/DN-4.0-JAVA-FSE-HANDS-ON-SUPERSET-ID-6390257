import React, { Component } from 'react';

class Posts extends Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: [],
            hasError: false,
            error: null,
            errorInfo: null
        };
    }

    async loadPosts() {
        try {
            const response = await fetch('https://jsonplaceholder.typicode.com/posts');

            if (!response.ok) {
                throw new Error(`Failed to fetch posts: ${response.status} ${response.statusText}`);
            }

            const data = await response.json();
            this.setState({ posts: data });

        } catch (error) {
            console.error("Error in loadPosts method:", error);
            throw error;
        }
    }

    componentDidMount() {
        console.log('componentDidMount: Component has mounted. Initiating data fetch...');
        this.loadPosts();
    }

    componentDidCatch(error, info) {
        console.error("componentDidCatch: An error was caught!", error, info);
        this.setState({
            hasError: true,
            error: error,
            errorInfo: info
        });
        alert(`An error occurred within the component tree: ${error.message}\nCheck your browser's console for more details.`);
    }

    render() {
        if (this.state.hasError) {
            return (
                <div>
                    <h2>Oops! Something went wrong.</h2>
                    <p>Error: {this.state.error ? this.state.error.toString() : 'Unknown error'}</p>
                    {this.state.errorInfo && (
                        <details>
                            <summary>Component Stack Trace</summary>
                            <pre>{this.state.errorInfo.componentStack}</pre>
                        </details>
                    )}
                    <p>Please try refreshing the page.</p>
                </div>
            );
        }

        if (this.state.posts.length === 0) {
            return (
                <div>
                    <p>Loading blog posts...</p>
                </div>
            );
        }

        return (
            <div>
                <h1>Our Latest Blog Posts</h1>
                {this.state.posts.map(post => (
                    <div key={post.id}>
                        <h2>{post.title}</h2>
                        <p>{post.body}</p>
                    </div>
                ))}
            </div>
        );
    }
}

export default Posts;