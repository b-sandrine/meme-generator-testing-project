import Header from '../components/Header';

describe('<Header>', () => {
    it('mounts', () => {
        cy.mount(<Header></Header>);
    })
})