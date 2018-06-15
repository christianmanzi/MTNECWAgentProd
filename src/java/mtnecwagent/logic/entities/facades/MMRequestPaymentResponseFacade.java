/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtnecwagent.logic.entities.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mtnecwagent.logic.entities.MMRequestPaymentResponse;

/**
 *
 * @author manzi
 */
@Stateless
public class MMRequestPaymentResponseFacade extends AbstractFacade<MMRequestPaymentResponse> {

    @PersistenceContext(unitName = "MTNECWAgentPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MMRequestPaymentResponseFacade() {
        super(MMRequestPaymentResponse.class);
    }
    
}
