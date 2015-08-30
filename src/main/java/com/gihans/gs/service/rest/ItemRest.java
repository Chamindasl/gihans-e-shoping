/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.service.rest;

import com.gihans.gs.model.Brand;
import com.gihans.gs.model.Category;
import com.gihans.gs.model.Item;
import com.gihans.gs.model.vo.ItemVO;
import com.gihans.gs.utils.StringUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

@Stateless
@Path("/item")
public class ItemRest {

    @PersistenceContext(unitName = "gihans_PU")
    private EntityManager em;

    private final String UPLOADED_FILE_PATH = "C:\\wildfly-8.2.0\\welcome-content\\ges\\uploaded\\";
    private final String URL_PATH = "/ges/uploaded/";

    @POST
    @Path("create")
    @Consumes("multipart/form-data")
    public Response addItem(final MultipartFormDataInput input, @Context Response response) throws URISyntaxException {
        final Item item;
        try {
            final Long id = readLong(input, "id");
            if (id == 0) {
                item = new Item();
            } else {
                item = em.find(Item.class, id);
            }
            item.setName(readString(input, "name"));
            item.setPrice(readDouble(input, "price"));
            item.setFresh(readBoolean(input, "fresh"));
            item.setOnSale(readBoolean(input, "onSale"));
            item.setFeatured(readBoolean(input, "featured"));
            item.setStock(readInteger(input, "stock"));
            item.setDescription(readString(input, "description"));
            item.setStartFrom(readDate(input, "startFrom"));
            item.setActive(Boolean.TRUE);
            final String subCat = readString(input, "subCategory");
            final String cat = readString(input, "category");
            if (StringUtils.isEmpty(subCat)) {
                item.setCategory(em.find(Category.class, Integer.valueOf(subCat)));
            } else {
                item.setCategory(em.find(Category.class, Integer.valueOf(cat)));
            }
            final String brand = readString(input, "brand");
            if (!StringUtils.isEmpty(brand)) {
                item.setBrand(em.find(Brand.class, Integer.valueOf(brand)));
            }
            if (null == item.getId()) {
                em.persist(item);
                em.flush();
            }

            item.setMainImage(saveImageAndGetPath(item.getId(), input, "mainImage"));
            item.setCartImage(saveImageAndGetPath(item.getId(), input, "cartImage"));
            item.setIndexImage(saveImageAndGetPath(item.getId(), input, "indexImage"));
            em.merge(item);
            java.net.URI location = new java.net.URI("../#/item/set-recommended?item=" + item.getId());
            return Response.seeOther(location).build();

        } catch (final NumberFormatException | URISyntaxException ex) {
            // need to handle exception properly
            return Response.serverError().build();
        }

    }

    @GET
    @Path("get")
    @Produces("application/json")
    public ItemVO getItem(@QueryParam(value = "id") final long id) {
        final Item item = em.find(Item.class, id);
        final ItemVO itemVO = new ItemVO(item);
        return itemVO;
    }

    @GET
    @Path("list")
    @Produces("application/json")
    public List<ItemVO> getItems() {
        final List<Item> items = em.createQuery("select i from Item i", Item.class).getResultList();
        final List<ItemVO> result = new ArrayList<>();
        for (final Item i : items) {
            result.add(new ItemVO(i));
        }
        return result;
    }

    private String saveImageAndGetPath(final Long id, final MultipartFormDataInput input, final String img) {

        try {
            writeFile(IOUtils.toByteArray(input.getFormDataMap().get(img).get(0).getBody(InputStream.class, null)), UPLOADED_FILE_PATH + id + "_" + img + ".jpg");
            return URL_PATH + id + "_" + img + ".jpg";
        } catch (Exception ex) {
            System.out.println(" unable to write the file");
            return null;
        }

    }

    //save to somewhere
    private void writeFile(byte[] content, String filename) throws IOException {
        if (null != content && content.length > 0) {
            final File file = new File(filename);
            if (!file.exists()) {
                file.createNewFile();
            }
            try (FileOutputStream fop = new FileOutputStream(file)) {
                fop.write(content);
                fop.flush();
            }
        }
    }

    private Double readDouble(final MultipartFormDataInput input, final String param) {
        try {
            return Double.valueOf(input.getFormDataMap().get(param).get(0).getBodyAsString());
        } catch (IOException | NumberFormatException ex) {
            return 0.0d;
        }
    }

    private Integer readInteger(final MultipartFormDataInput input, final String param) {
        try {
            return Integer.valueOf(input.getFormDataMap().get(param).get(0).getBodyAsString());
        } catch (IOException | NumberFormatException ex) {
            return 0;
        }
    }

    private Long readLong(final MultipartFormDataInput input, final String param) {
        try {
            return Long.valueOf(input.getFormDataMap().get(param).get(0).getBodyAsString());
        } catch (NullPointerException | IOException | NumberFormatException ex) {
            return 0l;
        }
    }

    private Boolean readBoolean(final MultipartFormDataInput input, final String param) {
        try {
            return Boolean.valueOf(input.getFormDataMap().get(param).get(0).getBodyAsString());
        } catch (Exception ex) {
            return Boolean.FALSE;
        }
    }

    private String readString(final MultipartFormDataInput input, final String param) {
        try {
            return input.getFormDataMap().get(param).get(0).getBodyAsString();
        } catch (Exception ex) {
            return "";
        }
    }

    private Date readDate(final MultipartFormDataInput input, final String startFrom) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(input.getFormDataMap().get(startFrom).get(0).getBodyAsString());
        } catch (IOException | ParseException ex) {
            return new Date();
        }
    }
}
