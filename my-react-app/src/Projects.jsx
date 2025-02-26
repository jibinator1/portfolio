import React, { useState } from 'react';
import './Projects.css';

const projects = [//create an image with id and image file location
    { id: 1, image: '/images/bok-chourney.png' },
    { id: 2, image: '/images/unisear-Front.png' },
    { id: 3, image: '/images/javascript.png' },
    { id: 4, image: '/images/freecodecamp-data-cert.png' },
    { id: 5, image: '/images/freecodecamp-js-cert.png' },
];

function Projects() {
    const [isHovered, setIsHovered] = useState(false);//isHovered is the current state with SetIsHovered is called when we want to change isHovered

    return (
        <div><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><h1>My Projects/Certificates</h1>
            <section className="projects-section">
                <div className="projects-container">
                    {projects.map((project) => (//go through each project to do the same div stuff to 
                        <div
                            key={project.id}
                            className={`project ${project.id === 4 || project.id === 5 ? 'smaller' : ''}`} //make the size smaller when id = 4 and 5 (since these are the certificates and have diff sizes)
                            onMouseEnter={() => setIsHovered(true)}//when mouse is within the image, increase the size
                            onMouseLeave={() => setIsHovered(false)}//when mouse is not within the image, decrease the size
                        >
                            <img
                                src={project.image}
                                alt={`Project ${project.id}`}
                                className={`project-image ${isHovered ? 'hovered' : ''}`}//change the css depending on whether the image is veing hovered
                            />
                        </div>
                    ))}
                </div>
            </section>
        </div>
    );
}

export default Projects;
