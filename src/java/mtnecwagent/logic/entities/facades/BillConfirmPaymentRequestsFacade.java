/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtnecwagent.logic.entities.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mtnecwagent.logic.entities.BillConfirmPaymentRequests;

/**
 *
 * @author manzi
 */
@Stateless
public class BillConfirmPaymentRequestsFacade extends AbstractFacade<BillConfirmPaymentRequests> {

    @PersistenceContext(unitName = "MTNECWAgentPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BillConfirmPaymentRequestsFacade() {
        super(BillConfirmPaymentRequests.class);
    }
    
}
