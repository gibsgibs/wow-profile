const Character = ({response}) => {
    return (
        <>
        <div className="card">
            <h1>
                Character
            </h1>
            <p>
                {response.name}-{response.realm}, {response.level} {response.active_spec} {response.character_class}
            </p>
            <p>
                Average ilvl: {response.equipped_item_level}
            </p>
            <p>
                {response.last_login_timestamp}
            </p>
        </div>
            
        </>
    );
}
export { Character }