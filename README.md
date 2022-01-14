# AnimalFacts
Master Web Java Project

# Documentation

This is a Spring Boot API that is used for sharing Random Animal Facts


## Features

### CRUD for Admins
    1. CREATE endpoints for all entities
    2. READ endpoints for all entities
    3. UPDATE endpoints for all entities
    4. DELETE endpoints for all entities
### Random Facts
    1. Receive random facts
    2. Receive random facts for a certain Animal
### User Reactions for Facts
    1. Send Comments
    2. Send Feedback (Liked, Disliked)
### Recommendations
    1. Send a Suggestion for a Fact, as a User
    2. See all pending Suggestions, as an Admin
    3. Approve a Suggestion, creating an entry in the Fact entity, as an Admin
    4. Reject a Suggestion, as an Admin
    
It has 6 Entities\
    1. Animal\
    2. Comment\
    3. Fact\
    4. Feedback\
    5. Image\
    6. Suggestions
    
That have relationships described in the following diagram

![Entity Diagram](https://user-images.githubusercontent.com/49075040/149546741-a13d40f0-d636-47a3-86e5-43af0040df2b.PNG)

Each features has a Controller.

## Routes
### CRUD
The CRUD controller uses the following route pattern:
"/crud/{entity}"

For **CREATE**, the HTTP verb used is **POST** and the entity is sent in the Request Body, as a JSON.

For **READ**, the HTTP verb used is **GET**, a certain entity can be read by adding it as a query paramter.\
If the route "/{entity}s" is used, (for example /animals"), all the entities that exist in the persistance layer are retrieved.

For **UPDATE**, the HTTP verb used is **PUT** and the entity is sent in the Request Body, including the id.

For **DELETE**, the HTTP verb used is **DELETE** and the entity is sent selected by sending the id as a query paramter.

### Random

The route "**/random/fact**" is used for getting 1 random fact, a "count" parameter can be specified as a query parameter to get more random facts.

The route "**/random/{animal_name}/fact**" can be specified to get random facts that are only related to a specific animal.

### User reactions

Users can send comments and feedback to facts by using the route "**/reaction/{reaction_type}/fact/{fact_id}**", where reaction_type can be either "**comment**" or "**feedback**".

### Recommendations

Users can send Suggestions by using the route "**/recommendation/{animal}/fact**".

Admins can check all pending suggestions using "**/recommendation/queue**" and can either approve or reject suggestions with "**/recommendation/{suggestion_id}/{approve/reject}**"

Approved suggestions are added as Facts.
