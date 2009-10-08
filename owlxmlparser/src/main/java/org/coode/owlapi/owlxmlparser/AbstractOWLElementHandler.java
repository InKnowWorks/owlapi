package org.coode.owlapi.owlxmlparser;

import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.vocab.OWLXMLVocabulary;
/*
 * Copyright (C) 2006, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */


/**
 * Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Bio-Health Informatics Group<br>
 * Date: 13-Dec-2006<br><br>
 */
public abstract class AbstractOWLElementHandler<O> implements OWLElementHandler<O> {

    private OWLXMLParserHandler handler;

    private OWLElementHandler parentHandler;


    private StringBuilder sb;

    private String elementName;


    protected AbstractOWLElementHandler(OWLXMLParserHandler handler) {
        this.handler = handler;
    }

    public IRI getIRIFromAttribute(String localName, String value) throws OWLXMLParserException {
        if(localName.equals(OWLXMLVocabulary.IRI_ATTRIBUTE.getShortName())) {
            return getIRI(value);
        }
        else if(localName.equals(OWLXMLVocabulary.ABBREVIATED_IRI_ATTRIBUTE.getShortName())) {
            return getAbbreviatedIRI(value);
        }
        else if(localName.equals("URI")) {
            // Legacy
            return getIRI(value);
        }
        throw new OWLXMLParserAttributeNotFoundException(getLineNumber(), OWLXMLVocabulary.IRI_ATTRIBUTE.getShortName());
    }


    public IRI getIRIFromElement(String elementLocalName, String textContent) throws OWLXMLParserException {
        if(elementLocalName.equals(OWLXMLVocabulary.IRI_ELEMENT.getShortName())) {
            return handler.getIRI(textContent.trim());
        }
        else if(elementLocalName.equals(OWLXMLVocabulary.ABBREVIATED_IRI_ELEMENT.getShortName())) {
            return handler.getAbbreviatedIRI(textContent.trim());
        }
        throw new OWLXMLParserException(getLineNumber(), elementLocalName + " is not an IRI element");
    }


    protected OWLOntologyManager getOWLOntologyManager() throws OWLXMLParserException {
        return handler.getOWLOntologyManager();
    }


    protected OWLOntology getOntology() {
        return handler.getOntology();
    }


    protected OWLDataFactory getOWLDataFactory() {
        return handler.getDataFactory();
    }


    public void setParentHandler(OWLElementHandler handler) {
        this.parentHandler = handler;
    }


    protected OWLElementHandler getParentHandler() {
        return parentHandler;
    }


    public void attribute(String localName, String value) throws OWLXMLParserException {
        throw new OWLXMLParserUnexpectedElementException(handler.getLineNumber(), getElementName());
    }

    protected IRI getIRI(String iri) throws OWLXMLParserException {
        return handler.getIRI(iri);
    }

    protected IRI getAbbreviatedIRI(String abbreviatedIRI) throws OWLXMLParserException {
        return handler.getAbbreviatedIRI(abbreviatedIRI);
    }

//    protected URI getIRI(String uri) throws OWLXMLParserException {
//        return handler.getIRI(uri);
//    }

    protected int getLineNumber() {
        return handler.getLineNumber();
    }

    // TODO: Make final
    public void startElement(String name) throws OWLXMLParserException {
        sb = null;
        elementName = name;
    }

    protected String getElementName() throws OWLXMLParserException {
        return elementName;
    }


    public void handleChild(AbstractOWLAxiomElementHandler handler) throws OWLXMLParserException {
        throw new OWLXMLParserUnexpectedElementException(getLineNumber(), handler.getElementName());
    }


    public void handleChild(AbstractClassExpressionElementHandler handler) throws OWLXMLParserException {
        throw new OWLXMLParserUnexpectedElementException(getLineNumber(), handler.getElementName());
    }


    public void handleChild(AbstractOWLDataRangeHandler handler) throws OWLXMLParserException {
        throw new OWLXMLParserUnexpectedElementException(getLineNumber(), handler.getElementName());
    }


    public void handleChild(AbstractOWLObjectPropertyElementHandler handler) throws OWLXMLParserException {
        throw new OWLXMLParserUnexpectedElementException(getLineNumber(), handler.getElementName());
    }


    public void handleChild(OWLDataPropertyElementHandler handler) throws OWLXMLParserException {
        throw new OWLXMLParserUnexpectedElementException(getLineNumber(), handler.getElementName());
    }


    public void handleChild(OWLIndividualElementHandler handler) throws OWLXMLParserException {
        throw new OWLXMLParserUnexpectedElementException(getLineNumber(), handler.getElementName());
    }


    public void handleChild(OWLConstantElementHandler handler) throws OWLXMLParserException {
        throw new OWLXMLParserUnexpectedElementException(getLineNumber(), handler.getElementName());
    }


    public void handleChild(OWLAnnotationElementHandler handler) throws OWLXMLParserException {
        throw new OWLXMLParserUnexpectedElementException(getLineNumber(), handler.getElementName());
    }


    public void handleChild(OWLSubObjectPropertyChainElementHandler handler) throws OWLXMLParserException {
        throw new OWLXMLParserUnexpectedElementException(getLineNumber(), handler.getElementName());
    }


    public void handleChild(OWLDatatypeFacetRestrictionElementHandler handler) throws OWLXMLParserException {
        throw new OWLXMLParserUnexpectedElementException(getLineNumber(), handler.getElementName());
    }

    public void handleChild(OWLAnnotationPropertyElementHandler handler) throws OWLXMLParserException {
        throw new OWLXMLParserUnexpectedElementException(getLineNumber(), handler.getElementName());
    }

    public void handleChild(OWLAnonymousIndividualElementHandler handler) throws OWLXMLParserException {
        throw new OWLXMLParserUnexpectedElementException(getLineNumber(), handler.getElementName());
    }

    public void handleChild(AbstractIRIElementHandler handler) throws OWLXMLParserException {
        throw new OWLXMLParserUnexpectedElementException(getLineNumber(), handler.getElementName());
    }

    public void handleChild(SWRLIndividualVariableElementHandler handler) throws OWLXMLParserException {
        throw new OWLXMLParserUnexpectedElementException(getLineNumber(), handler.getElementName());
    }

    public void handleChild(SWRLLiteralVariableElementHandler handler) throws OWLXMLParserException {
        throw new OWLXMLParserUnexpectedElementException(getLineNumber(), handler.getElementName());
    }

    public void handleChild(SWRLAtomElementHandler handler) throws OWLXMLParserException {
        throw new OWLXMLParserUnexpectedElementException(getLineNumber(), handler.getElementName());
    }

    public void handleChild(SWRLAtomListElementHandler handler) throws OWLXMLParserException {
        throw new OWLXMLParserUnexpectedElementException(getLineNumber(), handler.getElementName());
    }

    final public void handleChars(char[] chars, int start, int length) {
        if (isTextContentPossible()) {
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(chars, start, length);
        }
    }


    public String getText() {
        if (sb == null) {
            return "";
        }
        else {
            return sb.toString();
        }
    }


    public boolean isTextContentPossible() {
        return false;
    }
}
